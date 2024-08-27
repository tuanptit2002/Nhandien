package com.example.Be_Java.Config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration

@RequiredArgsConstructor
public class SecurityConfig {



//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(cors -> applicationConfig.corsConfigurationSource())
//                .authorizeHttpRequests(authorize -> {
//                    authorize.requestMatchers("/test/**").hasRole("USER")
//                            .requestMatchers("/auth/**").permitAll()
//                            .anyRequest().authenticated();
//                })
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
}
