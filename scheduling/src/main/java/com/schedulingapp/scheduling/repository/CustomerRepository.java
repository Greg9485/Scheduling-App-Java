package com.schedulingapp.scheduling.repository;

import com.schedulingapp.scheduling.model.Appointment;
import com.schedulingapp.scheduling.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, java.lang.Long> {

    @Query(value = "select * from customer where id = ?1", nativeQuery = true)
    public com.schedulingapp.scheduling.model.Customer getCustomerById(int customerId);

    @Query(value = "select * from customer where id = ?1", nativeQuery = true)
    public Customer findByCustomerId(Long id);

}

