package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_id")
    private Long permissionId;
    @Column(name = "permission_name")
    private String permissionName;
    private String URL;
    private boolean hasSubCategory;
    private String iconPath;
    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;

}
