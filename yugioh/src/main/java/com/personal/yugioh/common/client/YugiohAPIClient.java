package com.personal.yugioh.common.client;

import com.personal.yugioh.dto.YugiohResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;


@Service
@RequiredArgsConstructor
public class YugiohAPIClient {

    public Mono<String> getYugiohCardPrice(String yugiohApiUrl) {

        System.out.println("URL YUGIOH API: " + yugiohApiUrl);

        URI uri = UriComponentsBuilder
                .fromUriString(yugiohApiUrl)
                .build()
                .toUri();

        WebClient webClient = WebClient.create();

        return webClient.get()
                .uri(uri)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));
    }

    private YugiohResponse convertToYugiohResponse(ClientResponse clientResponse){
        //return clientResponse.body();
        return null;
    }

}
