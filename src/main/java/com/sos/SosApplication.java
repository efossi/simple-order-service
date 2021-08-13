package com.sos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SosApplication extends SpringBootServletInitializer
        implements WebMvcConfigurer {

        public static void main(String[] args) {
                SpringApplication.run(SosApplication.class, args);
        }

}
