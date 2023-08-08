package com.employee.portal.controller;

import com.employee.portal.configprops.ConfigPropertiesFromDefault;
import com.employee.portal.configprops.CredProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/test")
public class TestController {



    @Autowired
    ConfigPropertiesFromDefault defProps;

 @Autowired
    Environment env;

 @Value("${creds.username}")
    String name;
    @Autowired
    CredProps props;
    @GetMapping
    public void getData()
    {
        System.out.println("using @Value..."+name);
        System.out.println("java home..."+env.getProperty("JAVA_HOME"));
        System.out.println("env value for name...."+env.getProperty("creds.name"));
        System.out.println("Custom file username..."+props.getUsername());
        System.out.println("Custom file password..."+props.getPassword());

        System.out.println("def username::" + defProps.getUsername());
        System.out.println("def password::" + defProps.getPassword());

        System.out.println("list of emails..."+defProps.getEmail());

        System.out.println("map of emp headers university..."+defProps.getEmpHeaders().get("university"));

        System.out.println("map of emp headers college..."+defProps.getEmpHeaders().get("college"));

        System.out.println( "user object username.."+defProps.getUser().getUsername());
        double salary = defProps.getUser().getSalary();
        System.out.println( "user object username.."+ salary);
        boolean allowed = defProps.getUser().isAllowed();
        System.out.println( "user object isallwoed.."+allowed);
        System.out.println( "user object username.."+defProps.getUser().getUsername());


    }
}
