

package com.example.workforcemanagement.model;
import lombok.Data;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Developer")
public class Developer extends Employee {
    private int projectCount;
    private double projectBonus;

    @Override
    public double calculateSalary(){
        return getBaseSalary() + projectCount * projectBonus;
    }
}