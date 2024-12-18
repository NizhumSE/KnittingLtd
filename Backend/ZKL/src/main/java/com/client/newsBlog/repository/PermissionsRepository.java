package com.client.newsBlog.repository;

import com.client.newsBlog.model.Permissions;
import com.client.newsBlog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
    Permissions findByPermissionId(Long permissionId);
    Permissions findPermissionsByPermissionName(String permissionName);
    Permissions findPermissionsByURL(String url);
}
