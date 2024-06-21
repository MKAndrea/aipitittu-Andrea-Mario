package it.utente.webSecurityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import it.utente.crud.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(); 
    }

       @Bean
        UserDetailsService userDetailsService() {
          return new UserDetailsServiceImpl();
       }
       
        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
          http
                .authorizeHttpRequests(authorize -> authorize
                      .requestMatchers("/register", "/login").permitAll()
                      .anyRequest().authenticated())
                .formLogin(form -> form
                      .loginPage("/login")
                      .defaultSuccessUrl("/api/allShop", true)
                      .permitAll())
                .logout(logout -> logout
                      .permitAll())
                .userDetailsService(userDetailsService());

          return http.build();
       } 
 
}
