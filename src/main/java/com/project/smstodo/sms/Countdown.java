package com.project.smstodo.sms;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;


@Component
public class Countdown {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    // get all items from personal table
    public String getStringItems() throws IOException, ParseException {
        URL url = new URL("http://localhost:8080/api/v1/personal");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        Scanner sc = new Scanner(url.openStream());
        String inline = "";
        while(sc.hasNext()) {
            inline += sc.nextLine();
        }
        sc.close();

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(inline);
        JSONArray arr = (JSONArray) obj;
        String str = "\\n Your tasks: \\n";

        for (int i = 0; i < arr.size(); i++) {
            JSONObject jobj = (JSONObject) arr.get(i);
            str += "-" + jobj.get("item") + "\\n";
        }

        return str;
    }

    // send personal items as sms message
    public void postData() throws JSONException, ParseException, IOException {
        String str = getStringItems();
        System.out.println(str);

        URL url = new URL ("http://localhost:8080/api/v1/sms/");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");
        con.setDoOutput(true);

        String jsonInputString = "{\"phoneNumber\": \"+13364470831\", \"message\":" + "\"" + str + "\"" + "}";

        try(OutputStream os = con.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "utf-8"))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }
}
