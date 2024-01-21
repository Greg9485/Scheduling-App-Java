package com.schedulingapp.scheduling.controller;

import com.schedulingapp.scheduling.dto.AppointmentVO;
import com.schedulingapp.scheduling.dto.AppointmentsWithEmployeeCustomerInfo;
import com.schedulingapp.scheduling.dto.CustomerVO;
import com.schedulingapp.scheduling.model.Customer;
import com.schedulingapp.scheduling.model.Employee;
import com.schedulingapp.scheduling.service.AppointmentService;
import com.schedulingapp.scheduling.service.CustomerService;
import com.schedulingapp.scheduling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private AppointmentService appointmentService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    @Autowired
    public CustomerController(AppointmentService appointmentService,
                                 EmployeeService employeeService,
                                 CustomerService customerService) {
        this.appointmentService = appointmentService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerVO newCustomer) {
        try {

            String response = this.customerService.addCustomer(newCustomer);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = this.customerService.getallCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }


    @PutMapping(value = "/updateCustomer/{id}")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerVO customerVO,
                                                 @PathVariable("id") Integer id){
        try{
            this.customerService.updateCustomer(customerVO, id);
            return new ResponseEntity<>("Success" , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Integer id) {
        try {
            this.customerService.deleteCustomer(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
    }
}
