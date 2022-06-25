package com.example.spring_boot.api;

import com.example.spring_boot.entity.Employees;
import com.example.spring_boot.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/employees")
public class EmployeesApi {
    @Autowired
    EmployeesService employeesService;
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Employees>> findAll(){
        return ResponseEntity.ok(employeesService.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Employees> employees = employeesService.findById(id);
        if (!employees.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        return ResponseEntity.ok(employees.get());//cos du lieu tra ve
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Employees> save(@RequestBody Employees employees){
        return ResponseEntity.ok(employeesService.save(employees));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "{id}")
    public ResponseEntity<Employees> update(@PathVariable int id, @RequestBody Employees updateEmployees){
        Optional<Employees> employees = employeesService.findById(id);
        if (!employees.isPresent()){
            ResponseEntity.badRequest().build();// khoong co du lieu tra ve
        }
        Employees exitsEmployees = employees.get();
        exitsEmployees.setName(updateEmployees.getName());
        exitsEmployees.setWage(updateEmployees.getWage());

        return ResponseEntity.ok(employeesService.save(exitsEmployees));//cos du lieu tra ve
    }
}
