package com.client.newsBlog.mapper.adminPanel.editMapperDTOtoEntity;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.model.PermissionSubCategory;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;

@Service
public class PermissionSubCategoryRequestEditDTOSetterMapper implements BiFunction<PermissionSubCategoryRequestDTO, PermissionSubCategory, PermissionSubCategory> {

    @Override
    public PermissionSubCategory apply(PermissionSubCategoryRequestDTO permissionSubCategoryRequestDTO, PermissionSubCategory permissionSubCategory) {
        permissionSubCategory.setSubCategoryName(permissionSubCategoryRequestDTO.getSubCategoryName() == null ? permissionSubCategory.getSubCategoryName() : permissionSubCategoryRequestDTO.getSubCategoryName());
        permissionSubCategory.setSubCategoryURL(permissionSubCategoryRequestDTO.getSubCategoryURL() == null ? permissionSubCategory.getSubCategoryURL() : permissionSubCategoryRequestDTO.getSubCategoryURL());
        return permissionSubCategory;
    }
}
