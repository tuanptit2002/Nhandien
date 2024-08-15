package com.example.Be_Java.Config;

import com.example.Be_Java.Entity.*;
import com.example.Be_Java.Service.Dm_statusService;
import com.example.Be_Java.Service.ParkingService;
import com.example.Be_Java.Service.TimeService;
import com.example.Be_Java.Service.VehicleService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class SimpleTextWebSocketHandler extends TextWebSocketHandler {

    private final VehicleService vehicleService;
    private final ParkingService parkingService;
    private final TimeService timeService;
    private final Dm_statusService dmStatusService;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("payload ne:  " + payload);
        try {
            JsonObject rootObject = JsonParser.parseString(payload).getAsJsonObject();
            String parking = rootObject.get("parking").getAsString();
            JsonObject predictionsObject = rootObject.getAsJsonObject("predictions");
            for (String key : predictionsObject.keySet()) {
                JsonObject predictionObject = predictionsObject.getAsJsonObject(key);

                String type_vehicle = predictionObject.get("type_vehicle").getAsString();
                String licensePlate = predictionObject.get("License Plate").getAsString();

                if (checkTotalVehicle(licensePlate)) {
                    checkIn(type_vehicle, licensePlate, parking);
                } else {
                    // th1 xe ra
                    Vehicle vehicleSaved = vehicleService.checkoutParking(licensePlate).getData();
                    if (vehicleSaved != null) {
                        String vehicle_id = String.valueOf(vehicleSaved.getId());
                        Time time = timeService.getByVehicle(vehicle_id).getData();
                        LocalDateTime currentDateTime = LocalDateTime.now();
                        time.setTime_out(currentDateTime);
                        timeService.create(time);
                        DM_Status dmStatus = dmStatusService.getByVehicle(vehicle_id).getData();
                        dmStatus.setOutStatus(Status.TRUE);
                        dmStatus.setInStatus(Status.FALSE);
                        dmStatusService.create(dmStatus);

                    }
                    else{
                        checkIn(type_vehicle, licensePlate, parking);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.sendMessage(new TextMessage("Hello, " + payload + "!"));
    }

    private boolean checkTotalVehicle(String licensePlate) {
        // kiểm tra xem có xe ở trong data ko
        List<Vehicle> vehicles = vehicleService.getLicensePlate(licensePlate).getData();
        return vehicles == null || vehicles.isEmpty();
    }

    private void checkIn(String type_vehicle, String licensePlate, String parking){
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicle_type(type_vehicle);
        vehicle.setLicense_plate(licensePlate);
        Parking parkingData = parkingService.getById(parking).getData();
        vehicle.setParking(parkingData);
        LocalDateTime currentDateTime = LocalDateTime.now();
        Time time = new Time();
        time.setTime_in(currentDateTime);
        Vehicle vehicleSave = (Vehicle) vehicleService.create(vehicle).getData();
        time.setVehicle(vehicleSave);
        timeService.create(time);
        DM_Status dmStatus = new DM_Status();
        dmStatus.setVehicle(vehicleSave);
        dmStatus.setInStatus(Status.TRUE);
        dmStatusService.create(dmStatus);
    }
}
