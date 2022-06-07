package com.example.bitcoinproject;

import com.example.bitcoinproject.configuration.ApplicationMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = ApplicationMode.class)
@SpringBootApplication
public class BitcoinProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BitcoinProjectApplication.class, args);
    }

}
