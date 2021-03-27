package it.csi.demetra.demetraws.zoo.services.http;


import it.csi.demetra.demetraws.zoo.shared.Constants;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class BdnHttpServices {


    public void httpClientPost() {
        try {

            URL url;
            url = new URL(Constants.BDN_URI);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(Constants.POST_REQUEST);
            con.setRequestProperty(Constants.CONTENT_TYPE, Constants.APPLICATION_JSON_UTF8);
            con.setRequestProperty(Constants.ACCEPT, Constants.APPLICATION_JSON);
            con.setDoOutput(true);
            String jsonInputString = Constants.BDN_URI_BODY_REQUEST;
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            int code = con.getResponseCode();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine);
                }
                try {
                    JSONObject jsonObject = new JSONObject(response.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}
