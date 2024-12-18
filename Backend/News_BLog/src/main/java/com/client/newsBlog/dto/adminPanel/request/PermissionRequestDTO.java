package com.client.newsBlog.dto.adminPanel.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PermissionRequestDTO {
    String permissionId;
    String url;
    String hasSubCategory;
    String permissionName;
    String iconPath;
}
