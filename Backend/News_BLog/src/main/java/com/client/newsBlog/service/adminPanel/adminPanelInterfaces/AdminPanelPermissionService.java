package com.client.newsBlog.service.adminPanel.adminPanelInterfaces;

import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.dto.adminPanel.response.SideMenuItemsDTO;

import java.util.List;

public interface AdminPanelPermissionService {
    List<PermissionRequestDTO> getAllPermissions();
    String addPermission(PermissionRequestDTO permissionRequestDTO);
    String deletePermission(String permissionName);
    String updatePermission(String permissionName, PermissionRequestDTO permissionRequestDTO);
    List<String> getAllPermissionName();
    String addSubCategoryToPermission(String permissionName, PermissionSubCategoryRequestDTO permissionSubCategoryDTO);
    String deleteSubCategoryFromPermission(String subCategoryName);
    String updateSubCategoryFromPermission(String subCategoryName,PermissionSubCategoryRequestDTO permissionSubCategoryDTO);
    List<SideMenuItemsDTO> getAllSideMenuItems();
}
