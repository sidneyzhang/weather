/**
 * 
 */
package com.mytest.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) throws Exception {
        // Configure Log4J
        PropertyConfigurator.configure(Main.class.getClassLoader().getResource(
                "log4j.properties"));

        // Read the Zip Code from the Command-line (if none supplied, use 60202)
        int zipcode = 60202;
        try {
            zipcode = Integer.parseInt(args[0]);
        } catch (Exception e) {
        }

        System.out.println("this is zipcod "+ zipcode);

        // Start the program
        new Main(zipcode).start();
    }

    private int zip;

    public Main(int zip) {
        this.zip = zip;
    }

    public void start() throws Exception {
        // Retrieve Data
        InputStream dataIn = new YahooRetriever().retrieve(zip);

        // Parse Data
        Weather weather = new YahooParser().parse(dataIn);

        // Format (Print) Data
        System.out.print(new WeatherFormatter().format(weather));

        // Format (Print) Data
        System.out.print(new WeatherFormatter().format(weather));
    }
}