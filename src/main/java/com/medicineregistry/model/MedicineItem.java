package com.medicineregistry.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicineItem {
    private int id;
    private MedicineType medicineType;
    private String title;
    private String category;
    private List<String> expirationDate;
    private String container;
    private List<Double> amountValue;

}
