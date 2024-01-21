package com.schedulingapp.scheduling.dto;

import com.schedulingapp.scheduling.model.Customer;
import com.schedulingapp.scheduling.model.Employee;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class AppointmentVO {

    private Integer appointmentId;
    private String title;
    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private Date createdDate;
    private String createdBy;
    private Timestamp lastUpdated;
    private String lastUpdatedBy;
    private String customerName;
    private String employeeName;
    private int customerId;
    private int employeeId;



}
