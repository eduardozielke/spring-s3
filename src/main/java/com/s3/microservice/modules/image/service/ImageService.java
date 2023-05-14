package com.s3.microservice.modules.image.service;

import org.springframework.stereotype.Service;

@Service
public class ImageService {

    public String test() {
        throw new IllegalArgumentException("aa");
    }
}