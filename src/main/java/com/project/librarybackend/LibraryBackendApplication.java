package com.project.librarybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@EntityScan(basePackages = {"com.project.librarybackend.models"})
@SpringBootApplication
public class LibraryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryBackendApplication.class, args);
    }

}
