package com.project.smstodo;

import com.project.smstodo.sms.Countdown;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONException;

import java.io.IOException;

@SpringBootApplication
public class SmsTodoApplication {

	public static void main(String[] args) throws IOException, JSONException, ParseException {
		SpringApplication.run(SmsTodoApplication.class, args);

		Countdown countdown = new Countdown();

		try {
			// sends reminder every 12 hours
			while (true) {
				countdown.postData();
				Thread.sleep(43200 * 1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
