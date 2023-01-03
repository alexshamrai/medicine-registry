package com.medicineregistry;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class FileDownloader {

    private static final int CONNECT_TIMEOUT = 1000;
    private static final int READ_TIMEOUT = 1000;

    public void downloadFileToCsv(String url, String destination) throws IOException {
        FileUtils.copyURLToFile(
            new URL(url),
            new File(destination),
            CONNECT_TIMEOUT,
            READ_TIMEOUT);
    }
}
