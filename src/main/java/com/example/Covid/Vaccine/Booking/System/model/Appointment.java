package com.example.Covid.Vaccine.Booking.System.model;

import com.example.Covid.Vaccine.Booking.System.Enum.DoseNo;
import com.example.Covid.Vaccine.Booking.System.Enum.VaccineType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "appointment_id")
    String appointmentNo;

    @CreationTimestamp
    Date dateOfAppointment;

    @Column(name = "dose_no")
    @Enumerated(EnumType.STRING)
    DoseNo doseNo;

    @ManyToOne
    @JoinColumn
    User user;

    @ManyToOne
    @JoinColumn
    Doctor doctor;


}
