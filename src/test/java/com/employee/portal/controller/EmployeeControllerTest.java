package com.employee.portal.controller;

import com.employee.portal.dto.EmployeeDto;
import com.employee.portal.entity.EmployeeEntity;
import com.employee.portal.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @MockBean
    EmployeeService empService;

    @Autowired
    MockMvc mockMvc;

    EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
      employeeDto =  EmployeeDto.builder().age(22).ename("nagesh").salary(10000).build();

    }
    @Test
    void addEmployee() throws Exception {

        Mockito.when(empService.addEmployee(employeeDto)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.post("/employee/employees").contentType(MediaType.APPLICATION_JSON).content(" {\n" +
                "        \"ename\": \"praveen\",\n" +
                "        \"age\": 32,\n" +
                "        \"salary\": 500000.0\n" +
                "    }")).andExpect(MockMvcResultMatchers.status().isOk());

    }
}