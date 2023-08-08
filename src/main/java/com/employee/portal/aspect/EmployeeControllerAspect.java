package com.employee.portal.aspect;

import com.employee.portal.dto.EmployeeDto;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class EmployeeControllerAspect {

    Logger log = LoggerFactory.getLogger("EmployeeControllerLogger");
    @Before("execution(* com.employee.portal.controller.EmployeeController.getEmployees(..))")
    public void getEmployeeLogger()
    {
        log.info("getEmployee() method called.......");

    }
    @AfterReturning(value = "execution(* com.employee.portal.controller.EmployeeController.getEmployees(..))" , returning = "responseEntity")
    public void getEmployeeReturnLogger(ResponseEntity<List<EmployeeDto>> responseEntity)
    {
        log.info("getEmployee() returning......." + responseEntity.getBody().size());


    }
}
