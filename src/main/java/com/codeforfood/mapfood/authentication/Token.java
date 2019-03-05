package com.codeforfood.mapfood.authentication;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Classe criada para retornar informações sobre o token de comunicação com a API Maplink
 */
public class Token {
    private String clientId;
    private String clientSecret;
    private Properties prop = new Properties();

    public Token(){
        try {
            FileInputStream ip = new FileInputStream((System.getProperty("user.dir") + "/application.properties"));
            prop.load(ip);
            clientId = prop.getProperty("client_id");
            clientSecret = prop.getProperty("client_secret");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAccessToken(){
        // Verifica se o token ainda é válido
        if (!isValid()){
            // Caso não seja, solicita um novo token
            try {
                validateToken();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                prop.store(new FileOutputStream((System.getProperty("user.dir") + "/application.properties")), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return prop.getProperty("access_token");
    }

    /**
     * Verifica se o token atual ainda é valido
     * @return boolean
     */
    public boolean isValid(){
        if (prop.getProperty("requestDate") == null){
            return false;
        }
        else{
            Long longDate = Long.parseLong(prop.getProperty("requestDate"));
            Date dateRequest = new Date(longDate);
            Date now = new Date();

            long diff = Math.abs(now.getTime() - dateRequest.getTime());
            long diffInMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);

            if (diffInMinutes >= 55){
                return false;
            }
        }

        return true;
    }

    /**
     * Solicita um novo token
     */
    public void validateToken() throws Exception {
        URL obj = new URL("https://lbslocal-prod.apigee.net/oauth/client_credential/accesstoken?grant_type=client_credentials");
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(("client_id=" + clientId + "&client_secret=" + clientSecret).getBytes());
        os.flush();
        os.close();

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Date dt = new Date();
            Long thisDate = dt.getTime();

            JSONObject jsonObj = new JSONObject(response.toString());

            String token = jsonObj.get("access_token").toString();
            prop.setProperty("access_token", token);
            prop.setProperty("requestDate", thisDate.toString());
        }
    }
}
