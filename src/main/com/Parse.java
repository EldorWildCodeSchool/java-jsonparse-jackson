package com;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parse {

    private final static String JSON_WEATHER_PATH = "weather.json";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // write your code here !

            // TODO : get the root from the file JSON_WEATHER_PATH
            JsonNode root = objectMapper.readTree(new File("weather.json"));

            // TODO : get the value of "name" attribute
            String cityName = root.get("name").asText();

            // TODO : get the "lat" and "lon" values of the "coord"
            JsonNode coordNode = root.path("coord");
            Double cityLatitude = coordNode.get("lat").asDouble();
            Double cityLongitude = coordNode.get("lon").asDouble();

            // TODO : get the "wind" attribute as an com.Wind object
            Wind wind = objectMapper.convertValue(root.get("wind"), Wind.class);

            /*
            JsonNode windNode = root.path("wind");
            Wind wind = new Wind();
            if (!windNode.isMissingNode()){
              wind.setSpeed(windNode.get("speed").asDouble());
              wind.setDeg(windNode.get("deg").asDouble());
            }
             */

            // TODO : get the "weather" attribute as an array of com.Weather objects
            Weather[] weathers = objectMapper.convertValue(root.get("weather"), Weather[].class);

            // Don't touch this !
            System.out.printf("City name: %s%n", cityName);
            System.out.printf("City latitude: %s%n", cityLatitude);
            System.out.printf("City longitude: %s%n", cityLongitude);
            System.out.printf("com.Wind infos: %s%n", wind.toString());
            for (Weather weather : weathers) {
                System.out.printf("com.Weather infos: %s%n", weather.toString());
            }
            /*
                Expected result :

                City name: London
                City latitude: 51.51
                City longitude: -0.13
                com.Wind infos: src.main.com.Wind{speed=4.1, deg=80.0}
                com.Weather infos: src.main.com.Weather{id=300, main='Drizzle', description='light intensity drizzle', icon='09d'}
                com.Weather infos: src.main.com.Weather{id=800, main='Clear', description='clear sky', icon='01n'}
            */
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
