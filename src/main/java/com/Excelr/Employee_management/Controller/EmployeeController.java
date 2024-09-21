package com.Excelr.Employee_management.Controller;
import com.Excelr.Employee_management.model.Employee;
import com.Excelr.Employee_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Excelr")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addemployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return service.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return service.updateEmployee(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }
    @GetMapping("/getemployee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return service.getEmployee(id);
    }
}

