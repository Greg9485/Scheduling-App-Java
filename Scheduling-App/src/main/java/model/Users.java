package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="users")
@Getter
@Setter
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="created_date")
    private Date createdDate;
    @Column(name="created_time")
    private Time createdTime;
    @Column(name="last_updated")
    private Timestamp lastUpdated;
    @Column(name="last_updated_by")
    private String lastUpdatedBy;

    @ManyToOne
    @JoinColumn(name="appointment")
    private Set<Appointments> appointments;

}
