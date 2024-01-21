package com.schedulingapp.scheduling.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class CustomerVO {
    private Integer customerId;
    private String customerName;
    private String address;
    private String zipCode;
    private String phoneNumber;
    private String isActive;
    private Date createdDate;
    private String createdBy;
    private Timestamp lastUpdated;
    private String lastUpdatedBy;
}
