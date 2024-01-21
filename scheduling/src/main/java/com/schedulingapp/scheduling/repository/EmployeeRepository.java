package com.schedulingapp.scheduling.repository;

import com.schedulingapp.scheduling.dto.EmployeeVO;
import com.schedulingapp.scheduling.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    @Query(value="SELECT * FROM employee;", nativeQuery = true)
    public List<Employee> getEmployees();

    @Query(value = "select * from employee where id = ?1", nativeQuery = true)
    public EmployeeVO getEmployeeById(int employeeId);

}