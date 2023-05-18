package com.example.Covid.Vaccine.Booking.System.model;

import com.example.Covid.Vaccine.Booking.System.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "email_id", unique = true, nullable = false)
    String emailId;

    @Column(name = "mobile_no", unique = true, nullable = false)
    String mobileNo;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    Gender gender;

    @Column(name = "is_dose1_taken")
    boolean isDose1Taken;

    @Column(name = "is_dose2_taken")
    boolean isDose2Taken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose1 dose1;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Dose2 dose2;

}
