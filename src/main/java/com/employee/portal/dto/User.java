package com.employee.portal.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class User {

    @Size(min = 5,max = 10,message = "username from props should be 5 to 10 charecters")
    String username;
    String password;
    boolean allowed;
    double salary;
}
