package com.medicineregistry;

import java.util.List;

import com.medicineregistry.google.SheetsServiceFacade;
import com.medicineregistry.model.MedicineItem;
import com.medicineregistry.model.MedicineType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MedicineRegistryService {

    private final SheetsServiceFacade sheetsServiceFacade;

    public List<MedicineItem> getMedicineForAdults() {
        return sheetsServiceFacade.getAllMedicineItems(MedicineType.FOR_ADULTS);
    }

    public List<MedicineItem> getMedicineForChildren() {
        return sheetsServiceFacade.getAllMedicineItems(MedicineType.FOR_CHILDREN);
    }

}
