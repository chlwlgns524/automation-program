package com.example.bitcoinproject.configuration;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "application")
public class ApplicationMode {

    private String mode;

    public ApplicationModeType getApplicationMode() {
        return ApplicationModeType.getEnumFromString(mode);
    }

}
