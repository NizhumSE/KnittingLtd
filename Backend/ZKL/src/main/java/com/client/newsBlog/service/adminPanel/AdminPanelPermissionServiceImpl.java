package com.client.newsBlog.service.adminPanel;

import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.dto.adminPanel.response.SideMenuItemsDTO;
import com.client.newsBlog.mapper.adminPanel.EntityToDTO.PermissionDTOGetterMapper;
import com.client.newsBlog.mapper.adminPanel.EntityToDTO.SideMenuItemsDTOGetterMapper;
import com.client.newsBlog.mapper.adminPanel.createMapperDTOtoEntity.PermissionRequestDTOSetterMapper;
import com.client.newsBlog.mapper.adminPanel.createMapperDTOtoEntity.PermissionSubCategoryRequestDTOSetterMapper;
import com.client.newsBlog.mapper.adminPanel.editMapperDTOtoEntity.PermissionRequestEditDTOSetterMapper;
import com.client.newsBlog.mapper.adminPanel.editMapperDTOtoEntity.PermissionSubCategoryRequestEditDTOSetterMapper;
import com.client.newsBlog.model.PermissionSubCategory;
import com.client.newsBlog.model.Permissions;
import com.client.newsBlog.repository.PermissionSubCategoryRepository;
import com.client.newsBlog.repository.PermissionsRepository;
import com.client.newsBlog.service.adminPanel.adminPanelInterfaces.AdminPanelPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminPanelPermissionServiceImpl implements AdminPanelPermissionService {
    private final PermissionsRepository permissionsRepository;
    private final PermissionDTOGetterMapper permissionDTOGetterMapper;
    private final PermissionRequestDTOSetterMapper permissionRequestDTOSetterMapper;
    private final PermissionRequestEditDTOSetterMapper permissionRequestEditDTOSetterMapper;
    private final PermissionSubCategoryRequestDTOSetterMapper permissionSubCategoryRequestDTOSetterMapper;
    private final PermissionSubCategoryRepository permissionSubCategoryRepository;
    private final PermissionSubCategoryRequestEditDTOSetterMapper permissionSubCategoryRequestEditDTOSetterMapper;
    private final SideMenuItemsDTOGetterMapper sideMenuItemsDTOGetterMapper;

    public List<PermissionRequestDTO> getAllPermissions() {
        return permissionsRepository.findAll().stream().map(permissionDTOGetterMapper).toList();
    }

    @Override
    public String addPermission(PermissionRequestDTO permissionRequestDTO) {
        Permissions permissions = permissionsRepository.findPermissionsByPermissionName(permissionRequestDTO.getPermissionName());
        if (permissions != null) {
            return "permissionAlreadyExist";
        }
        permissions = permissionsRepository.findPermissionsByURL(permissionRequestDTO.getUrl());
        if (permissions != null) {
            return"PermissionUrlAlreadyExist";
        }
        String param = "";
        try {
            permissions = permissionRequestDTOSetterMapper.apply(permissionRequestDTO);
            permissionsRepository.save(permissions);
            param = "PermissionAdded";
        }catch (Exception e) {
            System.out.println(e);
            param = "SomethingWentWrong";
        }

        return param;
    }

    @Override
    public String deletePermission(String permissionName) {
        Permissions permissions = permissionsRepository.findPermissionsByPermissionName(permissionName);
        if(permissions == null){
            return "PermissionNotExist";
        }
        List<PermissionSubCategory> permissionSubCategories = permissionSubCategoryRepository.findAllByPermissions_permissionName(permissionName);
        permissionSubCategoryRepository.deleteAll(permissionSubCategories);
        permissionsRepository.delete(permissions);
        return "permissionDeleted";
    }

    @Override
    public String updatePermission(String permissionName, PermissionRequestDTO permissionRequestDTO) {
        Permissions permissions = permissionsRepository.findPermissionsByPermissionName(permissionName);
        if(permissions == null){
            return "permissionNotExist";
        }
        permissions = permissionRequestEditDTOSetterMapper.apply(permissionRequestDTO, permissions);
        permissionsRepository.save(permissions);
        return "updatedPermission";
    }

    @Override
    public List<String> getAllPermissionName() {
        return permissionsRepository.findAll().stream().map(Permissions::getPermissionName).toList();
    }

    @Override
    public String addSubCategoryToPermission(String permissionName, PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        Permissions permissions = permissionsRepository.findPermissionsByPermissionName(permissionName);
        if (permissions == null) {
            return "permissionNotExist";
        }

        PermissionSubCategory permissionSubCategory = permissionSubCategoryRepository.findBySubCategoryName(permissionSubCategoryDTO.getSubCategoryName());
        if (permissionSubCategory != null) {
            return "permissionSubCategoryAlreadyExist";
        }

        permissionSubCategory = permissionSubCategoryRepository.findBySubCategoryURL(permissionSubCategoryDTO.getSubCategoryURL());
        if (permissionSubCategory != null) {
            return"permissionSubCategoryUrlAlreadyExist";
        }

        permissionSubCategoryDTO.setPermissions(permissions);
        permissionSubCategory = permissionSubCategoryRequestDTOSetterMapper.apply(permissionSubCategoryDTO);
        permissionSubCategoryRepository.save(permissionSubCategory);
        return "permissionSubCategoryAdded";
    }

    @Override
    public String deleteSubCategoryFromPermission(String subCategoryName) {
        PermissionSubCategory permissionSubCategory = permissionSubCategoryRepository.findBySubCategoryName(subCategoryName);
        if(permissionSubCategory == null) {
            return "subCategoryNotExist";
        }
        permissionSubCategoryRepository.delete(permissionSubCategory);
        return "subCategoryDeleted";
    }

    @Override
    public String updateSubCategoryFromPermission(String subCategoryName,PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        PermissionSubCategory permissionSubCategory = permissionSubCategoryRepository.findBySubCategoryName(subCategoryName);
        if(permissionSubCategory == null){
            return "subCategoryNotExist";
        }
        permissionSubCategory = permissionSubCategoryRequestEditDTOSetterMapper.apply(permissionSubCategoryDTO, permissionSubCategory);
        permissionSubCategoryRepository.save(permissionSubCategory);
        return "updatedPermissionSubCategory";
    }

    @Override
    public List<SideMenuItemsDTO> getAllSideMenuItems() {
        List<Permissions> allPermissions = permissionsRepository.findAll();
        List<SideMenuItemsDTO> sideMenuItemsDTOS = new ArrayList<>();
        for(Permissions permission : allPermissions){
            sideMenuItemsDTOS.add(sideMenuItemsDTOGetterMapper.apply(permission));
        }
        return sideMenuItemsDTOS;
    }
}
