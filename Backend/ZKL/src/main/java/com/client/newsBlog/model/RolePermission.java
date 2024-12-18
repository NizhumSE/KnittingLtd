package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "role_permission")
public class RolePermission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_permission_id")
    private Long rolePermissionId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "permission_id")
    private Permissions permissions;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_id")
    private Role role;

    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
