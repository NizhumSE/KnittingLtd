package com.client.newsBlog.dto.adminPanel.response;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class SideMenuItemsDTO {
    String permissionId;
    String url;
    String hasSubCategory;
    String permissionName;
    String iconPath;
    List<PermissionSubCategoryRequestDTO> subCategoryList;
}
