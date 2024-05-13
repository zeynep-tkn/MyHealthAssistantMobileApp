package com.zeyneptekin.myhealthassistant;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Properties;

public class OpenAIChat {
    static String API_KEY = "";
    //Key bal, bu proje grubu harici kullanan mal
    //ben ve bu proje grubu harici kullanan olursa sağlam bozuşurum.

    static String API_URL = "https://api.openai.com/v1/chat/completions";
    static String model = "gpt-3.5-turbo";
    public static String sendRequest(String prompt) {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
            connection.setRequestProperty("Content-Type", "application/json");

            connection.setDoOutput(true);

            String systemPrompt = "Sen bir sağlık asistanısın. İsmin Robix. Cevaplara Türkçe cevap ver.";
            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"system\", \"content\": \""+ systemPrompt +"\"}, {\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";

            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

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

            // Yanıt içeriğini işleme
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject usage = jsonResponse.getJSONObject("usage");
            int totalTokens = usage.getInt("total_tokens");
            Log.d("OpenAIChat", "Total tokens used: " + totalTokens);
            JSONArray choices = jsonResponse.getJSONArray("choices");
            JSONObject firstChoice = choices.getJSONObject(0);
            JSONObject message = firstChoice.getJSONObject("message");
            String content = message.getString("content");

            return content ;
            //+ "\n\nTest\nTotal Token: "+totalTokens;

        } catch (Exception e) {
            e.printStackTrace();
            return "Hata, API'ye erişim sağlanamadı";
        }
    }


}