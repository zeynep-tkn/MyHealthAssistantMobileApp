package com.zeyneptekin.myhealthassistant;

import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class OpenAIChat {
    private static final String API_KEY = "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";
    //Key bal, bu proje grubu harici kullanan mal
    //ben ve bu proje grubu harici kullanan olursa sağlam bozuşurum.
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String model = "gpt-3.5-turbo-1106";
    public static String sendRequest(String prompt) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setDoOutput(true);

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            /*
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = data.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            */
            writer.write(body);
            writer.flush();
            writer.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            Log.d("OpenAIChat", "Response: " + response.toString());
            return (response.toString().split("\"content\":\"")[1].split("\"")[0]).substring(4);
        } catch (Exception e) {
            e.printStackTrace();
            return "Hata, Apı de sorun var";
        }
    }
}
