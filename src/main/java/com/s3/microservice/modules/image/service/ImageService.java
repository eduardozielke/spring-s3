package com.s3.microservice.modules.image.service;

import com.s3.microservice.config.env.AppProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    public String getEnv() {
        return AppProperties.AMAZON;
    }

    public String test() throws IllegalArgumentException  {
        throw new IllegalArgumentException("aa");
    }
}