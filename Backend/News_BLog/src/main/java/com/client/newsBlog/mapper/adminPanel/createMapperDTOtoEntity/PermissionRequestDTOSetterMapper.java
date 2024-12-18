package com.client.newsBlog.mapper.adminPanel.createMapperDTOtoEntity;

import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.model.Permissions;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PermissionRequestDTOSetterMapper implements Function<PermissionRequestDTO, Permissions> {
    @Override
    public Permissions apply(PermissionRequestDTO permissionRequestDTO) {
        Permissions permissions = new Permissions();
        permissions.setPermissionName(permissionRequestDTO.getPermissionName());
        permissions.setURL(permissionRequestDTO.getUrl());
        permissions.setHasSubCategory(Boolean.parseBoolean(permissionRequestDTO.getHasSubCategory()));
        return permissions;
    }
}
