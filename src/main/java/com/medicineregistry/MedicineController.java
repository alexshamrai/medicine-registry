package com.medicineregistry;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MedicineController {

    private static final String SPREADSHEET_ID = "1JEe3rjEI2kElNQTwsGKz4NFazp5Vny-LNlyfeIH0vNI";
    private static final String FOR_ADULTS = "Adult's";
    private static final String FOR_CHILDREN = "Children's";

    private final GoogleSheetsServiceFacade googleSheetsServiceFacade;

    @GetMapping("/children")
    public List<List<Object>> children() {
        return googleSheetsServiceFacade.getSheetContent(SPREADSHEET_ID, FOR_CHILDREN);
    }

    @GetMapping("/adults")
    public List<List<Object>> adults() {
        return googleSheetsServiceFacade.getSheetContent(SPREADSHEET_ID, FOR_ADULTS);
    }
}
