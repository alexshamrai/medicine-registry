package com.medicineregistry;

import com.medicineregistry.google.SheetsServiceFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicineRegistryConfiguration {

    @Bean
    SheetsServiceFacade sheetsServiceFacade() {
        return new SheetsServiceFacade();
    }

    @Bean
    MedicineRegistryService medicineRegistryService(SheetsServiceFacade sheetsServiceFacade) {
        return new MedicineRegistryService(sheetsServiceFacade);
    }

}
