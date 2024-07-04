package com.sunshine.co.BINI.STORE.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private UserDetailService UserDetailsService;

    public SecurityConfig(UserDetailsService UserDetailsService) {
        this.UserDetailsService = UserDetailsService;
    }

    @Bean
    static PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    AuthenticationManager authenticationManager( AuthenticationConfiguration configuration)
    throws Exception{
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain SecurityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(crsf -> csrf.disable())
                .authorizeHttpRequests((authorize) ->
                    authorize.requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
                            .requestMatchers("/api/v1/auth/**").permitAll()
                            .anyRequest().authenticated()
                );

        return http.build()  ;      
    }

}
