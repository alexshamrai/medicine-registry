package com.medicineregistry.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.medicineregistry.model.MedicineItem;
import com.medicineregistry.model.MedicineType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SheetsServiceFacade {

    private static final int ID_INDEX = 0;
    private static final int TITLE_INDEX = 1;
    private static final int CATEGORY_INDEX = 2;
    private static final int EXPIRATION_DATE_INDEX = 3;
    private static final int CONTAINER_INDEX = 4;
    private static final int AMOUNT_INDEX = 5;
    private static final String SPREADSHEET_ID = "1JEe3rjEI2kElNQTwsGKz4NFazp5Vny-LNlyfeIH0vNI";

    public List<MedicineItem> getAllMedicineItems(MedicineType medicineType) {
        var rows = readAllRowsFromSheet(medicineType.getSheetName());
        var medicineItems = new ArrayList<MedicineItem>();

        if (rows == null || rows.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (int i = 1; i < rows.size(); i++) {
                var row = rows.get(i);
                var number = getItemNumber(row);
                var title = getTitle(row);
                var category = getCategory(row);
                var expirationDate = getExpirationDate(row);
                var container = getContainer(row);
                var amount = getAmount(row);

                var medicineItem = MedicineItem.builder()
                                               .id(number)
                                               .medicineType(medicineType)
                                               .title(title)
                                               .category(category)
                                               .expirationDate(expirationDate)
                                               .container(container)
                                               .amountValue(amount)
                                               .build();
                medicineItems.add(medicineItem);
            }
        }
        return medicineItems;
    }

    private String getContainer(List<Object> row) {
        return row.size() > CONTAINER_INDEX ? row.get(CONTAINER_INDEX).toString() : "";
    }

    private List<Double> getAmount(List<Object> row) {
        var initialString = row.size() > AMOUNT_INDEX ? row.get(AMOUNT_INDEX).toString() : "";
        if (initialString.isEmpty() || initialString.equals("-")) {
            return Collections.emptyList();
        }
        var stringAmount = Arrays.asList(initialString.split(","));
        return stringAmount.stream().map(Double::parseDouble).collect(Collectors.toList());
    }

    private List<String> getExpirationDate(List<Object> row) {
        var initialString = row.size() > EXPIRATION_DATE_INDEX ? row.get(EXPIRATION_DATE_INDEX).toString() : "";
        if (initialString.isEmpty() || initialString.equals("-")) {
            return Collections.emptyList();
        }
        return Arrays.asList(initialString.split(","));
    }

    private String getCategory(List<Object> row) {
        return row.size() > CATEGORY_INDEX ? row.get(CATEGORY_INDEX).toString() : "";
    }

    private String getTitle(List<Object> row) {
        return row.size() > TITLE_INDEX ? row.get(TITLE_INDEX).toString() : "";
    }

    private int getItemNumber(List<Object> row) {
        return row.size() > ID_INDEX ? Integer.parseInt(row.get(ID_INDEX).toString()) : 0;
    }

    @SneakyThrows
    //TODO Add error handling
    private List<List<Object>> readAllRowsFromSheet(String sheetName) {
        var sheetsService = SheetsService.getSheetsService();

        String range = sheetName + "!A1:Z";
        var response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        var values = response.getValues();

        if (values == null || values.isEmpty()) {
            log.info("No data found in the sheet {}", values);
        } else {
            log.info("Data found spreadsheetID: {}, name: {}", SPREADSHEET_ID, sheetName);
        }

        return values;
    }
}
