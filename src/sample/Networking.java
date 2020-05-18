package sample;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Networking {
    public void getData() throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException {
        URL url = new URL("https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/");
        PrintWriter writer = new PrintWriter("data.xml", "UTF-8");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;

            // Read the "gpl.txt" text file from its URL representation
            System.out.println("Downloading xml data..");
            while((inputLine = in.readLine()) != null) {
                writer.println(inputLine);
//                System.out.println(inputLine);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
