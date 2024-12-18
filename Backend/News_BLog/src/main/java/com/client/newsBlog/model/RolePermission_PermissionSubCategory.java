package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "role_permission_permission_sub_category")
public class RolePermission_PermissionSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_permission_permission_sub_category_id")
    private Long rolePermissionPermissionSubCategoryId;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "permission_sub_category_id")
    private PermissionSubCategory permissionSubCategory;
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "role_permission_id")
    private RolePermission rolePermission;
}
