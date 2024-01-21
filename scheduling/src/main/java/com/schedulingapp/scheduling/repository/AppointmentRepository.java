package com.schedulingapp.scheduling.repository;

import com.schedulingapp.scheduling.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, java.lang.Long> {

    @Query(value = "select * from appointment where id = ?1", nativeQuery = true)
    public Appointment findByAppointmentId(Long id);


    @Query(value = "select id from `scheduling-app`.appointment where customer_id = ?1", nativeQuery = true)
    public ArrayList<Long> findAllAppointmentIdsByCustomerId(Integer id);

    @Transactional
    @Modifying
    @Query(value = "delete from `scheduling-app`.appointment where customer_id = ?1", nativeQuery = true)
    public void deleteAppointmentsByCustomerId(Integer id);
}
