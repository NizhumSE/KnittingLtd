package com.client.newsBlog.mapper.adminPanel.EntityToDTO;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.dto.adminPanel.response.SideMenuItemsDTO;
import com.client.newsBlog.model.PermissionSubCategory;
import com.client.newsBlog.model.Permissions;
import com.client.newsBlog.repository.PermissionSubCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class SideMenuItemsDTOGetterMapper implements Function<Permissions, SideMenuItemsDTO> {

    @Override
    public SideMenuItemsDTO apply(Permissions permissions) {
        return new SideMenuItemsDTO(
                Long.toString(permissions.getPermissionId()),
                permissions.getURL(),
                Boolean.toString(permissions.isHasSubCategory()),
                permissions.getPermissionName(),
                permissions.getIconPath(),
                getSubCategories(permissions)
        );
    }

    private final PermissionSubCategoryDTOGetterMapper permissionSubCategoryDTOGetterMapper;
    private final PermissionSubCategoryRepository permissionSubCategoryRepository;

    private List<PermissionSubCategoryRequestDTO> getSubCategories(Permissions permissions){
        if(!permissions.isHasSubCategory()){
            return null;
        }
        List<PermissionSubCategory> permissionSubCategory = permissionSubCategoryRepository.findAllByPermissions_permissionName(permissions.getPermissionName());
        return permissionSubCategory.stream().map(permissionSubCategoryDTOGetterMapper).toList();
    }
}
