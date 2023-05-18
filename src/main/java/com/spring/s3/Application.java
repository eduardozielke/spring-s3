package com.spring.s3;

import com.spring.s3.modules.s3.S3Buckets;
import com.spring.s3.modules.s3.S3Service;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    CommandLineRunner runner(
            S3Service s3Service,
            S3Buckets s3Buckets
    ) {
        return args -> {
//            s3Service.putObject("zielkebucket","myHelloWorldTest","Hello World".getBytes());

            byte[] myBucketObject = s3Service.getObject(s3Buckets.getCustomer(), "myHelloWorldTest");

            System.out.println("my s3 object: " + new String(myBucketObject));
        };
    }

}
