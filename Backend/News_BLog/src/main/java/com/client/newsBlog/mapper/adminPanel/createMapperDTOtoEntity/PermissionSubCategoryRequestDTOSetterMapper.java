package com.client.newsBlog.mapper.adminPanel.createMapperDTOtoEntity;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.model.PermissionSubCategory;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PermissionSubCategoryRequestDTOSetterMapper implements Function<PermissionSubCategoryRequestDTO, PermissionSubCategory> {
    @Override
    public PermissionSubCategory apply(PermissionSubCategoryRequestDTO permissionSubCategoryRequestDTO) {
        PermissionSubCategory permissionSubCategory = new PermissionSubCategory();
        permissionSubCategory.setPermissions(permissionSubCategoryRequestDTO.getPermissions());
        permissionSubCategory.setSubCategoryURL(permissionSubCategoryRequestDTO.getSubCategoryURL());
        permissionSubCategory.setSubCategoryName(permissionSubCategoryRequestDTO.getSubCategoryName());
        return permissionSubCategory;
    }
}
