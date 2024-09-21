package io.pn.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsApplicationConfiguration {
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();

		// Allow requests from specific origins
		configuration.setAllowedOrigins(List.of("*"));

		// Allow specific HTTP methods
		configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));

		// Allow specific headers
		configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));

		// Allow credentials (e.g., cookies)
		configuration.setAllowCredentials(true);
		
		configuration.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return  source;
	}

}

// if don't work , in security we can use
/*
 * http.cors(cors -> cors.configurationSource(request -> { CorsConfiguration
 * configuration = new CorsConfiguration();
 * configuration.setAllowedOrigins(Arrays.asList("*"));
 * configuration.setAllowedMethods(Arrays.asList("*"));
 * configuration.setAllowedHeaders(Arrays.asList("*")); return configuration;
 * }));
 */


