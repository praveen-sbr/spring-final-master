package com.employee.portal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeEntity {
    String ename;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long eid;
    int age;
    double salary;


}