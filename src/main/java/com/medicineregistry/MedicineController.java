package com.medicineregistry;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MedicineController {

    private final CsvParser csvParser;

    @GetMapping("/children")
    public String children() {
        return csvParser.getMedicineForChildren();
    }

    @GetMapping("/adults")
    public String adults() {
        return csvParser.getMedicineForAdults();
    }
}
