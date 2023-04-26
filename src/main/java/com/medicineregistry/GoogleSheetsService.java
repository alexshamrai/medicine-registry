package com.medicineregistry;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;

public class GoogleSheetsService {

    private static final String APPLICATION_NAME = "medicine-registry";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException {
        var credentials = authorize();
        var httpTransport = GoogleNetHttpTransport.newTrustedTransport();

        HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(credentials);
        return new  Sheets.Builder(httpTransport, JSON_FACTORY, requestInitializer)
                            .setApplicationName(APPLICATION_NAME)
                            .build();
    }

    private static GoogleCredentials authorize()  throws IOException {
        String credentialsJson = System.getenv("GOOGLE_CREDENTIALS");
        return GoogleCredentials.fromStream(new ByteArrayInputStream(credentialsJson.getBytes()))
                                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
    }

}
