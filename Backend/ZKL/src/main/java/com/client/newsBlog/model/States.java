package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "states")
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "states_id")
    private Long statesId;

    @Column(name = "name")
    private String stateName;
    @ManyToOne
    @JoinColumn(name = "countriesAndCodes")                  //fk
    private CountriesCodes countriesCodes;
    @Column(name = "state_medical_visa_use_status")
    private String stateMedicalVisaUseStats = "0";  //0 == no use || 1 == use

    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
