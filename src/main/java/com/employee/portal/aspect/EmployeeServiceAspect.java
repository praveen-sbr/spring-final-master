package com.employee.portal.aspect;

import com.employee.portal.dto.EmployeeDto;
import jakarta.persistence.JoinTable;
import org.aspectj.lang.JoinPoint;
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
public class EmployeeServiceAspect {

    Logger log = LoggerFactory.getLogger("EmployeeServiceLogger");
    @Before("execution(* com.employee.portal.service.EmployeeService.addEmployee(..))")
    public void addEmployeeLogger(JoinPoint point)
    {
         Object[] dto =    point.getArgs();
        log.info("addEmployee() method called......."+dto[0]);

    }
    @AfterReturning(value = "execution(* com.employee.portal.service.EmployeeService.getEmployees(..))" , returning = "response")
    public void getEmployeeReturnLogger(List<EmployeeDto> response)
    {
        log.info("getEmployee() returning......." + response.size());


    }
}
