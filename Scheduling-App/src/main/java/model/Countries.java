package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;


@Entity
@Table(name="countries")
@Getter
@Setter
public class Countries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int countryId;
    @Column(name="country")
    private String country;
    @Column(name="created_date")
    private Date createDate;
    @Column(name="created_time")
    private Time createTime;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="last_updated")
    private LocalDateTime lastUpdated;
    @Column(name="last_updated_by")
    private String lastUpdatedBy;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private Set<FirstLevelDivisions> divisions;
}
