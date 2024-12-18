package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "countriesAndCodes")
public class CountriesCodes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "countriesAndCodes_id")
    private Long countriesAndCodesId;

    @Column(name = "country_short_name")
    private String countryShortName;
    @Column(name = "country_name")
    private String countryName;
    @Column(name = "country_code")
    private String countryCode;
    @Column(name = "country_medical_visa_use_status")
    private String countryMedicalVisaUseStats = "0";  //0 == no use || 1 == use

    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
