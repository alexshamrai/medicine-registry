package com.medicineregistry.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Getter
public enum MedicineType {

    FOR_ADULTS ("Adults"),
    FOR_CHILDREN ("Children");

    private final String sheetName;
}
