package com.s3.microservice.modules.image.controller;

import com.s3.microservice.modules.image.service.ImageService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService service;
    public ImageController(final ImageService imageService) {
        service = imageService;
    }

    @GetMapping
    public ResponseEntity<String> getEv() {
//        String env = service.getEnv();
        return new ResponseEntity<>("teste", HttpStatus.OK);
    }

    @GetMapping("/illegal")
    public ResponseEntity<String> test() {
        String teste = service.test();
        return new ResponseEntity<>(teste, HttpStatus.OK);
    }
}
