package com.medicineregistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicineRegistryConfiguration {

    @Bean
    FileDownloader fileDownloader() {
        return new FileDownloader();
    }

    @Bean
    CsvParser csvParser(FileDownloader fileDownloader) {
        return new CsvParser(fileDownloader);
    }

}
