package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="contacts")
@Getter
@Setter
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int contactId;
    @Column(name="contact_name")
    private String contactName;
    @Column(name="email")
    private String email;

    @ManyToOne
    @JoinColumn(name="appointment")
    private Set<Appointments> appointments;

}
