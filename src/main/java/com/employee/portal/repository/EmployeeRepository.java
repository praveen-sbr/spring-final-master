package com.employee.portal.repository;

import com.employee.portal.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

    EmployeeEntity findByEid(Long id);

}
