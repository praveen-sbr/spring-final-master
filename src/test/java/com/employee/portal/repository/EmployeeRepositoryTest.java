package com.employee.portal.repository;

import com.employee.portal.entity.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;
    @Autowired
    EmployeeRepository empRepo;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void addEmployee()
    {
        EmployeeEntity entity = EmployeeEntity.builder()
                .ename("Naresh").age(32).salary(20000)
                .build();
        System.out.println("...."+entity.getEid());
       EmployeeEntity entityObj = empRepo.save(entity);
       assertEquals(entityObj.getEname(),"Naresh");
    }
    @Test
    public void findByEid()
    {
        EmployeeEntity entity = EmployeeEntity.builder()
                .ename("Naresh").age(32).salary(20000)
                .build();
        EmployeeEntity entityObj = empRepo.save(entity);

        System.out.println("---"+entityObj.getEid());
        entityObj = empRepo.findByEid(entityObj.getEid());
        assertEquals(entityObj.getEname(),"Naresh");

    }
}