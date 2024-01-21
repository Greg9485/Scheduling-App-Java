package com.schedulingapp.scheduling.service;

import com.schedulingapp.scheduling.dto.AppointmentVO;
import com.schedulingapp.scheduling.dto.AppointmentsWithEmployeeCustomerInfo;
import com.schedulingapp.scheduling.dto.CustomerVO;
import com.schedulingapp.scheduling.dto.EmployeeVO;
import com.schedulingapp.scheduling.model.Appointment;
import com.schedulingapp.scheduling.model.Customer;
import com.schedulingapp.scheduling.model.Employee;
import com.schedulingapp.scheduling.repository.CustomerRepository;
import com.schedulingapp.scheduling.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getallCustomers(){
        List<Customer> customerList = customerRepository.findAll();
        return customerList;
    }


    public String addCustomer(CustomerVO customerVO){

        try {
            Customer customer = new Customer();

            customer.setCustomerName(customerVO.getCustomerName());
            customer.setAddress(customerVO.getAddress());
            customer.setCreatedBy("Greg Boydston");
            customer.setCreatedDate(customerVO.getCreatedDate());
            customer.setIsActive(customerVO.getIsActive());
            customer.setLastUpdated(new Timestamp(System.currentTimeMillis()));
            customer.setLastUpdatedBy("Greg Boydston");
            customer.setPhoneNumber(customerVO.getPhoneNumber());
            customer.setZipCode(customerVO.getZipCode());

            customerRepository.save(customer);
            return "Success";
        }catch(Exception e){
            return "Fail";
        }
    }


    public void updateCustomer(CustomerVO customerVO, Integer id){
        Customer customer = customerRepository.findByCustomerId(Long.valueOf(id.toString()));

        if(customer != null){
            customer.setCustomerName(customerVO.getCustomerName());
            customer.setAddress(customerVO.getAddress());
            customer.setCreatedBy("Greg Boydston");
            customer.setCreatedDate(customerVO.getCreatedDate());
            customer.setIsActive(customerVO.getIsActive());
            customer.setLastUpdated(new Timestamp(System.currentTimeMillis()));
            customer.setLastUpdatedBy("Greg Boydston");
            customer.setPhoneNumber(customerVO.getPhoneNumber());
            customer.setZipCode(customerVO.getZipCode());

            this.customerRepository.save(customer);
        }
    }

    public void deleteCustomer(Integer id){
        this.customerRepository.deleteById(Long.valueOf(id.toString()));
    }


}
