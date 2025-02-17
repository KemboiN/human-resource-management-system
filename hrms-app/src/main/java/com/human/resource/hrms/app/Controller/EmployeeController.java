package com.human.resource.hrms.app.Controller;

import com.human.resource.hrms.app.Dto.EmployeeDto;
import com.human.resource.hrms.app.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class EmployeeController
{
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/register/employee")
    public ResponseEntity<String> RegisterEmployee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.RegisterEmployee(employeeDto);
    }
    @PutMapping("/update/employee")
    public ResponseEntity<String> updateEmployee ( @RequestBody EmployeeDto employeeDto )
    {
        return employeeService.UpdateEmployee(employeeDto);
    }
    @DeleteMapping("/delete/employee")
    public ResponseEntity<String> deleteEmployee ( @RequestParam  String idNumber )
    {
        return employeeService.DeleteEmployee(idNumber);
    }
    @GetMapping("/employeeList")
    public ResponseEntity<String>employeeList ( )
    {
        return employeeService.GetAllEmployees();
    }


}
