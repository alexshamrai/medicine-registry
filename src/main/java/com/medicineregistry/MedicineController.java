package com.medicineregistry;

import java.util.List;

import com.medicineregistry.model.MedicineItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineRegistryService medicineRegistryService;

    @GetMapping("/children")
    public List<MedicineItem> children() {
        return medicineRegistryService.getMedicineForChildren();
    }

    @GetMapping("/adults")
    public List<MedicineItem> adults() {
        return medicineRegistryService.getMedicineForAdults();
    }
}
