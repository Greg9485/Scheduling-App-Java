package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="customers")
@Getter
@Setter
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int customerId;
    @Column(name="customer_name")
    private String customerName;
    @Column(name="address")
    private String address;
    @Column(name="zip_code")
    private String zipCode;
    @Column(name="phone_number")
    private String phoneNumber;
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

    //Foreign Key
    @OneToMany
    @JoinColumn(name="division_id")
    private FirstLevelDivisions division;

    @ManyToOne
    @JoinColumn(name="appointment")
    private Set<Appointments> appointments;

}
