package com.client.newsBlog.repository;

import com.client.newsBlog.model.RolePermission_PermissionSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermission_PermissionSubCategoryRepository extends JpaRepository<RolePermission_PermissionSubCategory, Long> {
}
