package com.medicineregistry;

import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GoogleSheetsServiceFacade {

    @SneakyThrows
    //TODO Add error handling
    private List<List<Object>> readAllContent(String spreadsheetId, String sheetName) {
        Sheets sheetsService = GoogleSheetsService.getSheetsService();

        String range = sheetName + "!A1:Z";
        ValueRange response = sheetsService.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();

        if (values == null || values.isEmpty()) {
            log.info("No data found in the sheet {}", values);
        } else {
            log.info("Data found spreadsheetID: {}, name: {}", spreadsheetId, sheetName);
        }

        return values;
    }

    public List<List<Object>> getSheetContent(String spreadsheetId, String sheetName) {
        return readAllContent(spreadsheetId, sheetName);
    }
}
