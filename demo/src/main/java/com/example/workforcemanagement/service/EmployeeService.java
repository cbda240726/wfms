
package com.example.workforcemanagement.model;
import com.example.workforcemanagement.model.Employee;
import com.example.workforcemanagement.repository.EmployeeRepository;
import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.treansaction.annoatation.EnableTransactionManagement;


import java.util.*;
@Service

public class EmployeeService{
    @Autowried
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }
    @Transactional
    public Employee saveEmployee(Employee employee){
        validateEmployee(employee);
        return employeeRepository.save(employee);
    }
    @Transactional(readOnly = true)
    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
    @Transactional
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    private void validateEmployee(Employee employee){
        if(employee.getAge() < 18){
            throw new IllegalArgumentException("age must be 18 older")
        }
    }
    @Transactional
    public void performMultipleOperations(Employee employee1, Employee employee2){
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }
}
