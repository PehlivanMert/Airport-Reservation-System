package dev.pehlivan.airportreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/test")
public class TestController {


    private RestTemplate restTemplate;

    @GetMapping("/{test}")
    public ResponseEntity<String> getTestResultFromRestTemplate(@PathVariable Integer test) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange("http://localhost:8080/test/" + test, HttpMethod.GET, entity, String.class);
    }

}
