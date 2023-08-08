package com.employee.portal.controller;


import com.employee.portal.configprops.ConfigPropertiesFromDefault;
import com.employee.portal.configprops.CredProps;
import com.employee.portal.dto.EmployeeDto;
import com.employee.portal.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @Autowired
    CredProps props;

    @Autowired
    ConfigPropertiesFromDefault defProps;
    @GetMapping("/employees")
    ResponseEntity<List<EmployeeDto>> getEmployees()
    {
        System.out.println("username:::"+props.getUsername());
        System.out.println("password:::"+props.getPassword());
        System.out.println("def username:::"+defProps.getUsername());
        System.out.println("def password:::"+defProps.getPassword());

        return new ResponseEntity<List<EmployeeDto>>( empService.getEmployees(),HttpStatus.OK);
    }
    @PostMapping("/employees")
    ResponseEntity<String> addEmployees(@RequestBody @Valid EmployeeDto empDto)
    {
        boolean isSave = empService.addEmployee(empDto);
       return new ResponseEntity<String>("Employees added successfully",HttpStatus.OK);

    }

    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDto> addEmployees(@PathVariable long id)  {
       EmployeeDto dto = empService.getEmployeeByID(id);
        return new ResponseEntity<EmployeeDto>(dto,HttpStatus.OK);

    }
  @PutMapping("/employee/{id}")
  ResponseEntity<EmployeeDto> updateEmployee(@PathVariable ("id")  long empId,@RequestBody EmployeeDto dto)
  {
      EmployeeDto dtoObj = empService.updateEmployee(empId, dto);

      return new ResponseEntity<EmployeeDto>(dtoObj,HttpStatus.OK);
  }


}
