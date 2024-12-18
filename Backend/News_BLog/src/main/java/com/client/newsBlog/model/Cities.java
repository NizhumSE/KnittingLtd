package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "cities")
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cities_id")
    private Long citiesId;
    @ManyToOne
    @JoinColumn(name = "state_id")                  //fk
    private States states;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "city_medical_visa_use_status")
    private String cityMedicalVisaUseStats = "0";  //0 == no use || 1 == use


    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;
}

