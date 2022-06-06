package com.study.kanapka.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", length = 60, nullable = false)
    private String firstName;

    @Column(name = "second_name", length = 10, nullable = false)
    private String secondName;

    @Column(name = "email", length = 60)
    @Email
    private String email;

    @Column(name = "address", length = 60)
    private String address;

    @Column(name = "guest_role", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private GuestRole role;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(mappedBy = "guest",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<Reservation> reservations;

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                '}';
    }
}

