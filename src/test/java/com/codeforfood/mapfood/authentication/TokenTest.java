package com.codeforfood.mapfood.authentication;

import org.junit.Test;

import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TokenTest {

    @Test
    public void isValidTest(){
        Properties prop = new Properties();
        Token token = new Token();
        try {
            FileInputStream ip = new FileInputStream((System.getProperty("user.dir") + "/application.properties"));
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (prop.getProperty("requestDate") == null){
            assertTrue(!token.isValid());
        }
        else {
            Long longDate = Long.parseLong(prop.getProperty("requestDate"));
            Date dateRequest = new Date(longDate);
            Date now = new Date();

            long diff = Math.abs(now.getTime() - dateRequest.getTime());
            long diffInMinutes = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS);

            if (diffInMinutes >= 55){
                assertTrue(!token.isValid());
            }
            else{
                assertTrue(token.isValid());
            }
        }
    }

    @Test
    public void validateTokenTest(){
        Properties prop = new Properties();
        Token token = new Token();
        try {
            FileInputStream ip = new FileInputStream((System.getProperty("user.dir") + "/application.properties"));
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String accessTokenOld = prop.getProperty("access_token");

        try {
            token.validateToken();

            try {
                FileInputStream ip = new FileInputStream((System.getProperty("user.dir") + "/application.properties"));
                prop.load(ip);
            } catch (Exception e) {
                e.printStackTrace();
            }

            assertTrue(prop.getProperty("access_token") != accessTokenOld);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAccessTokenTest(){
        Properties prop = new Properties();
        Token token = new Token();

        assertNotNull(token.getAccessToken());
    }
}
