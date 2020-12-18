package com.example.listviewmidterm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RepositoryURL {

        public String downloadurl(String s) throws IOException {
            URL url = new URL(s);
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            BufferedReader reader = null;

            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                inputStream = new BufferedInputStream(connection.getInputStream());
                reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder strb = new StringBuilder();
                String l;
                while ((l = reader.readLine()) != null) {
                    strb.append(l).append('\n');
                }
                return strb.toString();
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }

                if (inputStream != null) {
                    inputStream.close();
                }

                if (reader != null) {
                    reader.close();
                }
            }

            return null;
        }
}
