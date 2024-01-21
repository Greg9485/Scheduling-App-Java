package com.schedulingapp.scheduling.controller;

import com.schedulingapp.scheduling.dto.AppointmentVO;
import com.schedulingapp.scheduling.dto.AppointmentsWithEmployeeCustomerInfo;
import com.schedulingapp.scheduling.model.Appointment;
import com.schedulingapp.scheduling.model.Customer;
import com.schedulingapp.scheduling.model.Employee;
import com.schedulingapp.scheduling.service.CustomerService;
import com.schedulingapp.scheduling.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.schedulingapp.scheduling.service.AppointmentService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private AppointmentService appointmentService;
    private EmployeeService employeeService;
    private CustomerService customerService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService,
                                 EmployeeService employeeService,
                                 CustomerService customerService) {
        this.appointmentService = appointmentService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    @PostMapping("/addAppointment")
    public ResponseEntity<String> addAppointment(@RequestBody AppointmentVO newAppointment) {

        try {
            String response = this.appointmentService.addAppointment(newAppointment);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("fail", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllAppointments")
    public ResponseEntity<AppointmentsWithEmployeeCustomerInfo> getAllAppointments() {
        AppointmentsWithEmployeeCustomerInfo appointmentList = this.appointmentService.getAllAppointments();
        return new ResponseEntity<>(appointmentList, HttpStatus.OK);
    }

    @GetMapping("/getAllAppointmentsByCustomerId")
    public ResponseEntity<ArrayList<Integer>> getAllAppointmentsByCustomerId(@RequestParam("id") Integer id){
        ArrayList<Integer> appointmentIdList = this.appointmentService.getAllAppointmentsByCustomerId(id);
        return new ResponseEntity<>(appointmentIdList, HttpStatus.OK);
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = this.employeeService.getallEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = this.customerService.getallCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }


    @PutMapping(value = "/updateAppointment/{id}")
    public ResponseEntity<String> updateAppointment(@RequestBody AppointmentVO appointmentVO,
                                                    @PathVariable("id") Integer id){
        try{
            this.appointmentService.updateAppointment(appointmentVO, id);
            return new ResponseEntity<>("Success" , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/deleteAppointment/{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable("id") Integer id) {
        try {
            this.appointmentService.deleteAppointment(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteAppointmentsByCustomerId/{id}")
    public ResponseEntity<String> deleteAppointmentsByCustomerId(@PathVariable("id") Integer id) {
        try {
            this.appointmentService.deleteAppointmentsByCustomerId(id);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
        }
    }

}