package com.employee.portal.service;

import com.employee.portal.dto.EmployeeDto;
import com.employee.portal.entity.EmployeeEntity;
import com.employee.portal.exception.EmployeeNotFoundException;
import com.employee.portal.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {



    @Autowired
    EmployeeService empService;


    @MockBean
    ModelMapper mapper;

    @MockBean
    EmployeeRepository empRepo;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("add employee to DB")
    public void addEmployeeTest() {

        Mockito.when(mapper.map(getEmployeeDto(), EmployeeEntity.class)).thenReturn(getEmployeeEntity());

        Mockito.when(empRepo.save(getEmployeeEntity())).thenReturn(getEmployeeEntity());

        boolean isadded = empService.addEmployee(getEmployeeDto());
        assertEquals(true, isadded);
    }


    @Test
    public void getEmployeeByIDTestFound(){
        Mockito.when(empRepo.findByEid(1l)).thenReturn(getEmployeeEntity());
        Mockito.when(mapper.map(getEmployeeEntity(),EmployeeDto.class)).thenReturn(getEmployeeDto());
        assertNotNull(empService.getEmployeeByID(1l));
    }

    @Test
    public void getEmployeeByIDTestNotFound(){


        assertThrows(EmployeeNotFoundException.class,()->{
            Mockito.when(empRepo.findByEid(2l)).thenReturn(null);
            empService.getEmployeeByID(2l);
        });
    }

    @Test
    public void updateEmployeeTest()
    {
        Mockito.when(empRepo.findById(1l)).thenReturn(Optional.ofNullable(getEmployeeEntity()));

        Mockito.when(empRepo.save(getEmployeeEntity())).thenReturn(getEmployeeEntity());
        Mockito.when(mapper.map(getEmployeeEntity(),EmployeeDto.class)).thenReturn(getEmployeeDto());
        empService.updateEmployee(1l,getEmployeeDto());




    }
    public EmployeeDto getEmployeeDto() {
        EmployeeDto dto = EmployeeDto.builder()
                .age(25)
                .ename("Praveen")
                .salary(1000)
                .build();
        return dto;
    }

    public EmployeeEntity getEmployeeEntity() {
        EmployeeEntity empEntity = EmployeeEntity.builder()
                .age(25)
                .eid(1)
                .ename("Praveen")
                .salary(1000)
                .build();
        return empEntity;
    }

}