package com.client.newsBlog.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "permission_sub_category")
public class PermissionSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "permission_sub_category_id")
    private Long permissionSubCategoryId;
    @ManyToOne(cascade = {CascadeType.DETACH})
    @JoinColumn(name = "permission_id")
    private Permissions permissions;
    @Column(name = "sub_category_name")
    private String subCategoryName;
    @Column(name = "sub_category_url")
    private String subCategoryURL;
    @Column(name = "menu_icon_path")
    private String menuIconPath;


    @CreationTimestamp
    @Column(name="datecreated", updatable = false)
    private Timestamp dateCreated;
    @UpdateTimestamp
    private Timestamp updatedAt;
}
