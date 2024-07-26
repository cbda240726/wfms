
package com.example.workforcemanagement.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Manager")
public class Manager extends Employee {
    private double bonus;

    @Override
    public double calculateSalary(){
        return getBaseSalary() + bonus;
    }
}