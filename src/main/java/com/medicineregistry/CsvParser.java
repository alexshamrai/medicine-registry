package com.medicineregistry;

import java.nio.file.Files;
import java.nio.file.Path;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class CsvParser {

    private final FileDownloader fileDownloader;

    private static final String ADULTS_MEDICINE_URL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSEyFH1Do8qjrIL7HJ7OY3iueKfVrhXq4jeeLJ39Karc-OhkggowwWUQtOrIHWtpn384oUD0aW7vUHj/pub?gid=0&single=true&output=csv";
    private static final String CHILDRENS_MEDICINE_URL = "https://docs.google.com/spreadsheets/d/e/2PACX-1vSEyFH1Do8qjrIL7HJ7OY3iueKfVrhXq4jeeLJ39Karc-OhkggowwWUQtOrIHWtpn384oUD0aW7vUHj/pub?gid=1606725568&single=true&output=csv";
    private static final String ADULTS_FILE = "target/Adults.csv";
    private static final String CHILDRENS_FILE = "target/Childrens.csv";

    @SneakyThrows
    public String getMedicineForChildren() {
        fileDownloader.downloadFileToCsv(ADULTS_MEDICINE_URL, ADULTS_FILE);
        return Files.readString(Path.of(ADULTS_FILE));
    }

    @SneakyThrows
    public String getMedicineForAdults() {
        fileDownloader.downloadFileToCsv(CHILDRENS_MEDICINE_URL, CHILDRENS_FILE);
        return Files.readString(Path.of(CHILDRENS_FILE));
    }
}
