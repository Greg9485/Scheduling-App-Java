package com.schedulingapp.scheduling.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name="employee")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="email")
    private String email;

}
