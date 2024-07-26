
package com.example.workforcemanagement.model;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity

@Data
public abstract Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;



}