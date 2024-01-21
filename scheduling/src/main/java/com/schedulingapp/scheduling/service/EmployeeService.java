package com.schedulingapp.scheduling.service;

import com.schedulingapp.scheduling.model.Employee;
import com.schedulingapp.scheduling.repository.AppointmentRepository;
import com.schedulingapp.scheduling.repository.CustomerRepository;
import com.schedulingapp.scheduling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getallEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList;
    }

}
