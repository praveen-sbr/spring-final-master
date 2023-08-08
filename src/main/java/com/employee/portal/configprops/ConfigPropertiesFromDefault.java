package com.employee.portal.configprops;

import com.employee.portal.dto.EmployeeDto;
import com.employee.portal.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "creds")
@Component
@Data
public class ConfigPropertiesFromDefault {
    @Value("${creds.name}")
    private String name;
    @Size(min = 5,max = 10,message = "length should be (5-10)")
    private String username;
    private int password;

    List<String> email;

    Map<String,String> empHeaders;

    @Valid
    User user;

}
