package com.example.spring_boot.service;

import com.example.spring_boot.entity.Employees;
import com.example.spring_boot.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeesService {
@Autowired
    EmployeesRepository employeesRepository;

    public Employees save(Employees employees) {
        return employeesRepository.save(employees);
    }

    public List<Employees> findAll() {
        return employeesRepository.findAll();
    }

    public Optional<Employees> findById(int id) {
        return employeesRepository.findById(id);
    }
    public void deleteById(int id) {
        employeesRepository.deleteById(id);
    }
}
