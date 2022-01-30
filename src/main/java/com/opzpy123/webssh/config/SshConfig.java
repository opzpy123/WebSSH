package com.opzpy123.webssh.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "config.ssh")
public class SshConfig {

    private String host;
    private String port;
    private String username;
    private String password;

}
