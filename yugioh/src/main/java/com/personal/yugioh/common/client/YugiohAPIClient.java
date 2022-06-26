package com.personal.yugioh.common.client;

import com.personal.yugioh.dto.YugiohAPIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class YugiohAPIClient {

    @Value("${yugioh.price.service}")
    private String yugiohServiceUrl;

    public YugiohAPIResponse getYugiohCardPrice(String cardCode) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<YugiohAPIResponse> entity = new HttpEntity<YugiohAPIResponse>(headers);

        return restTemplate.exchange(yugiohServiceUrl + cardCode, HttpMethod.GET, entity, YugiohAPIResponse.class).getBody();
    }

}
