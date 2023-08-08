package com.employee.portal.dto;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value = "dev")
public class TestProfile {

    @PostConstruct
    public void PostConstruct()
    {
        System.out.println("TestProfile has been called....");
    }
}
