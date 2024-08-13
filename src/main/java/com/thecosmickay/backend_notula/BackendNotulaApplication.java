package com.thecosmickay.backend_notula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendNotulaApplication {

    public static void main(String[] args) {
        System.out.println("Starting up the server ================ [Step 1]");
        SpringApplication.run(BackendNotulaApplication.class, args);
        System.out.println("We are Live ================ [Step 2]");
    }
}
