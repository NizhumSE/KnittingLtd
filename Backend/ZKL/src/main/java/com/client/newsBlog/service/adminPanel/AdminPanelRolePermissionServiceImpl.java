package com.client.newsBlog.service.adminPanel;

import com.client.newsBlog.model.RolePermission;
import com.client.newsBlog.service.adminPanel.adminPanelInterfaces.AdminPanelRolePermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AdminPanelRolePermissionServiceImpl implements AdminPanelRolePermissionService {
    @Override
    public List<String> getPermissionName(List<RolePermission> rolePermission) {
        List<String> permissionList = new ArrayList<>();
        for(RolePermission rp : rolePermission) {
            permissionList.add(rp.getPermissions().getPermissionName());
        }
        return permissionList;
    }
}
