package com.pruebatec.demo.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;




@Configuration
@EnableWebSecurity
public class WebSecurityConfigurerAdapter {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsManager() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        
        // Agregar un usuario "admin" con contraseña "admin" y rol "ADMIN"
        userDetailsManager.createUser(User.withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN")
            .build());

        // Agregar un usuario "user" con contraseña "user" y rol "USER"
        userDetailsManager.createUser(User.withUsername("user")
            .password(passwordEncoder().encode("user"))
            .roles("USER")
            .build());
        
        return userDetailsManager;
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Desactiva CSRF para simplificar el ejemplo
            .authorizeHttpRequests(authorize -> authorize
                // Rutas accesibles solo para administradores (usuarios con el rol "ADMIN")
                .requestMatchers("/futbolistas/**").hasRole("ADMIN")
                // Rutas accesibles para usuarios con el rol "USER"
                .requestMatchers("/usuarios/**").hasRole("USER")
                // Otras rutas permitidas para todos los usuarios autenticados
                .anyRequest().authenticated()
            )
            .httpBasic() // Autenticación HTTP básica
            .and()
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        return http.build();
    }

}
