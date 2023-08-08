package com.employee.portal.service;


import ch.qos.logback.classic.spi.IThrowableProxy;
import com.employee.portal.dto.EmployeeDto;
import com.employee.portal.entity.EmployeeEntity;
import com.employee.portal.exception.EmployeeNotFoundException;
import com.employee.portal.repository.EmployeeRepository;
import jakarta.persistence.Entity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    ModelMapper mapper;


    public List<EmployeeDto> getEmployees() {
        List<EmployeeEntity> entityList = repository.findAll();
        System.out.println(entityList.size());

        return entityList.stream().map(employee -> mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());

    }

    public boolean addEmployee(EmployeeDto empDto) {
        EmployeeEntity entity = mapper.map(empDto, EmployeeEntity.class);
        entity = repository.save(entity);
        if (entity instanceof EmployeeEntity) {
            return true;
        } else {
            return false;
        }

    }

    public EmployeeDto getEmployeeByID(long id)  {
        EmployeeEntity entity = null;

            entity = repository.findByEid(id);
            if (entity != null) {
                return mapper.map(entity,EmployeeDto.class);
            }
            else {
              throw new EmployeeNotFoundException("Employee not found.."+id);
            }

    }

    public EmployeeDto updateEmployee(long empId, EmployeeDto dto) {


        EmployeeEntity entity = repository.findById(empId).orElseThrow(()-> new EmployeeNotFoundException("Employee not found for the id."+empId));

            if(Objects.nonNull(dto.getAge()) )
            {
                entity.setAge(dto.getAge());
            }
            if(Objects.nonNull(dto.getEname()) && !"".equalsIgnoreCase(dto.getEname()) )
            {
                entity.setEname(dto.getEname());
            }
            if(Objects.nonNull(dto.getSalary()) )
            {
                entity.setSalary(dto.getSalary());
            }



        EmployeeEntity entityObj = repository.save(entity);
         return mapper.map(entityObj , EmployeeDto.class);


    }
}
