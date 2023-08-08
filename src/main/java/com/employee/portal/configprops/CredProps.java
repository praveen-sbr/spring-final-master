package com.employee.portal.configprops;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@Configuration
@PropertySource("classpath:/Props/app.properties")
public class CredProps {
    @Value("${cred.username}")
    private String username;
    @Value("${cred.password}")
    private int password;

}
