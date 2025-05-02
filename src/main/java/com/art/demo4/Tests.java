package com.art.demo4;

import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class Tests {
    public static void main(String[] args) {

        final String uri = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/chisinau?unitGroup=us&key=JXCGDDUA54BUE88DVRXCBSN34&contentType=json";


        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        System.out.println(result);

    }
}
