
package com.example.workforcemanagement.Controller;
import com.example.workforcemanagement.model.Employee;
import com.example.workforcemanagement.repository.EmployeeRepository;
import org.springframework.bean.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
@RestController
//@RequestMapping("/api/employees")

public class EmployeeController{
    @Autowried
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employeeemployee){
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseENtity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseENtity.noContent().build();
    }
}
