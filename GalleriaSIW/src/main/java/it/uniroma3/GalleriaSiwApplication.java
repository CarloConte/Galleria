package it.uniroma3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class GalleriaSiwApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GalleriaSiwApplication.class, args);
	}
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GalleriaSiwApplication.class);
    }
}
