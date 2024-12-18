package com.client.newsBlog.service.adminPanel.adminPanelInterfaces;

import com.client.newsBlog.model.RolePermission;

import java.util.List;

public interface AdminPanelRolePermissionService {
    List<String> getPermissionName(List<RolePermission> rolePermission);

}
