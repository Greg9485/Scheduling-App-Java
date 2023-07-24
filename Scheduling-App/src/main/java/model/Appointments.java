package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="appointments")
@Getter
@Setter
public class Appointments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int appointmentId;

    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="loaction")
    private String location;
    @Column(name="type")
    private String type;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="start_time")
    private Time startTime;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="end_time")
    private Time endTime;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="created_time")
    private Time createdTime;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="last_updated")
    private Timestamp lastUpdated;
    @Column(name="last_updated_by")
    private String lastUpdatedBy;

    //FOREIGN KEYS
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
    private Customers customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
    private Users user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointments")
    private Contacts contact;
}
