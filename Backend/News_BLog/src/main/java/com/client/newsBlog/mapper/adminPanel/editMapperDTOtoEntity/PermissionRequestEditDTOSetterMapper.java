package com.client.newsBlog.mapper.adminPanel.editMapperDTOtoEntity;

import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.model.Permissions;
import org.springframework.stereotype.Service;

import java.util.function.BiFunction;


@Service
public class PermissionRequestEditDTOSetterMapper implements BiFunction<PermissionRequestDTO, Permissions, Permissions> {

    @Override
    public Permissions apply(PermissionRequestDTO permissionRequestDTO, Permissions permissions) {
        permissions.setPermissionName(permissionRequestDTO.getPermissionName() == null ? permissions.getPermissionName() : permissionRequestDTO.getPermissionName());
        permissions.setURL(permissionRequestDTO.getUrl() == null ? permissions.getURL() : permissionRequestDTO.getUrl());
        permissions.setHasSubCategory(permissionRequestDTO.getHasSubCategory() == null ? permissions.isHasSubCategory() : Boolean.parseBoolean(permissionRequestDTO.getHasSubCategory()));
        permissions.setIconPath(permissionRequestDTO.getIconPath() == null ? permissions.getIconPath() : permissionRequestDTO.getIconPath());
        return permissions;
    }
}
