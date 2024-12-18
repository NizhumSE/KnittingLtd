package com.client.newsBlog.repository;

import com.client.newsBlog.model.PermissionSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface PermissionSubCategoryRepository extends JpaRepository<PermissionSubCategory, Long> {
    List<PermissionSubCategory> findAllByPermissions_permissionName(String permissionName);
    PermissionSubCategory findBySubCategoryName(String subCategoryName);
    PermissionSubCategory findBySubCategoryURL(String subCategoryURL);
}
