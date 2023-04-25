package com.medicineregistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicineRegistryConfiguration {

    @Bean
    GoogleSheetsServiceFacade googleSheetsServiceFacade() {
        return new GoogleSheetsServiceFacade();
    }

}
