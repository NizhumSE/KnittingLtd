package com.client.newsBlog.repository;

import com.client.newsBlog.model.Permissions;
import com.client.newsBlog.model.Role;
import com.client.newsBlog.model.RolePermission;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface RolePermissionRepository extends JpaRepository <RolePermission, Long> {
    RolePermission findByRolePermissionId(Long rolePermissionId);
    RolePermission findByPermissionsAndRole(Permissions permissions, Role role);
    List<RolePermission> findByRole(Role role);
    RolePermission findByPermissions(Permissions permissions);
    RolePermission findByRole_RoleName(String roleName);
}
