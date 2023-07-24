package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


@Entity
@Table(name="first_level_divisions")
@Getter
@Setter
public class FirstLevelDivisions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int divisionId;
    @Column(name="division")
    private String division;
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

    //FOREIGN KEY
    @ManyToOne
    @JoinColumn(name="country_id", nullable = false)
    private Countries country;

}
