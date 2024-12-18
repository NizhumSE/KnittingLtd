package com.client.newsBlog.mapper.adminPanel.EntityToDTO;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.model.PermissionSubCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class PermissionSubCategoryDTOGetterMapper implements Function<PermissionSubCategory, PermissionSubCategoryRequestDTO> {
    @Override
    public PermissionSubCategoryRequestDTO apply(PermissionSubCategory permissionSubCategory) {
        return new PermissionSubCategoryRequestDTO(
                Long.toString(permissionSubCategory.getPermissionSubCategoryId()),
                permissionSubCategory.getPermissions().getPermissionName(),
                permissionSubCategory.getSubCategoryName(),
                permissionSubCategory.getSubCategoryURL(),
                permissionSubCategory.getMenuIconPath(),
                permissionSubCategory.getPermissions()
        );
    }

    public List<PermissionSubCategoryRequestDTO> apply(List<PermissionSubCategory> byPermissionsPermissionName) {
        return byPermissionsPermissionName.stream().map(this).toList();
    }
}
