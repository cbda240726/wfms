
package com.example.workforcemanagement.model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "employee_type", discriminatorType = DiscriminatoType.STRING)
@Data
public abstract class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double baseSalary;
    private int age;

    @MonyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private abstract double calculateSalaray();

}