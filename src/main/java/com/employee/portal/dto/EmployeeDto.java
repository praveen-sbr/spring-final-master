package com.employee.portal.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

    long eid;
@NotNull(message = "ename cannot be null")
    String ename;
    @Min(value =25,message = "min age value is 25")
    @Max(value = 50,message = "max age is 50")
    int age;
    double salary;

}
