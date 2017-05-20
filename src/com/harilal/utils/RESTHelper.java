package com.harilal.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.lang.StringEscapeUtils;

public class RESTHelper {

	private static final String APPLICATION_JSON = "application/json";
	private static final String ACCEPT = "Accept";
	private static final String GET = "GET";
	private static final String USER_AGENT = "Mozilla/5.0";

	public static String executeGetRequest(String urlString) {
		HttpURLConnection conn = null;
		StringBuilder stringBuilder = new StringBuilder();
		try {
			URL url = new URL(StringEscapeUtils.escapeHtml(urlString));
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod(GET);
			conn.setRequestProperty(ACCEPT, APPLICATION_JSON);

			if (conn.getResponseCode() != 200) {
				return "Failed : HTTP error code : " + conn.getResponseCode() + url;
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			while ((output = br.readLine()) != null) {
				stringBuilder.append(output);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return stringBuilder.toString();
	}

	public static String executePost(String url, String param) throws Exception {
		System.out.println(param);
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		// add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		String urlParameters = "[\"" + param + "\"]";
		con.setRequestProperty("Content-Length", String.valueOf(urlParameters.length()));
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		// print result
		return response.toString();

	}
}
