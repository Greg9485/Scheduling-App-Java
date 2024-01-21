package com.schedulingapp.scheduling.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name="appointment")
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long appointmentId;

    @Column(name="title")
    private String title;

    @Column(name="start_date")
    private String startDate;

    @Column(name="start_time")
    private String startTime;

    @Column(name="end_date")
    private String endDate;

    @Column(name="end_time")
    private String endTime;

    @Column(name="created_date")
    private Date createdDate;

    @Column(name="created_by")
    private String createdBy;

    @Column(name="last_updated")
    private Timestamp lastUpdated;

    @Column(name="last_updated_by")
    private String lastUpdatedBy;

    private int customerId;
    private int employeeId;

}
