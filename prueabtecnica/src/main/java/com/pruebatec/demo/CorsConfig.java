package com.pruebatec.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
	
	@Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        
        // Permite solicitudes desde el dominio http://localhost:5173
        corsConfig.addAllowedOrigin("http://localhost:5173");
        
        // Permite todas las cabeceras
        corsConfig.addAllowedHeader("*");
        
        // Permite todos los métodos HTTP
        corsConfig.addAllowedMethod("*");
        
        // Si es necesario, puedes habilitar credenciales
        corsConfig.setAllowCredentials(true);

        // Configura el origen basado en URL
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        
        // Devuelve un filtro de CORS que aplica la configuración a las solicitudes
        return new CorsFilter(source);
    }

}
