package com.client.newsBlog.controller.adminPanel;

import com.client.newsBlog.dto.adminPanel.request.PermissionSubCategoryRequestDTO;
import com.client.newsBlog.mapper.adminPanel.EntityToDTO.PermissionSubCategoryDTOGetterMapper;
import com.client.newsBlog.repository.PermissionSubCategoryRepository;
import com.client.newsBlog.service.adminPanel.adminPanelInterfaces.AdminPanelPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/auth/permissionsSubCategory")
@RequiredArgsConstructor
public class AdminPanelPermissionSubCategoryController {
    private final PermissionSubCategoryRepository permissionSubCategoryRepository;
    private final PermissionSubCategoryDTOGetterMapper permissionSubCategoryDTOGetterMapper;
    private final AdminPanelPermissionService adminPanelPermissionService;

    @GetMapping("/{permissionName}")
    public String PermissionSubCategory(Model model, @PathVariable("permissionName") String permissionName, @ModelAttribute("permissionSubCategoryDTO") PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        List<PermissionSubCategoryRequestDTO> permissionSubCategoryDTOList = permissionSubCategoryDTOGetterMapper.apply(permissionSubCategoryRepository.findAllByPermissions_permissionName(permissionName));
        model.addAttribute("permissionSubCategoryDTOList", permissionSubCategoryDTOList);

        model.addAttribute("permissionNameListDTO", adminPanelPermissionService.getAllPermissionName());
        model.addAttribute("selectedPermissionName", permissionName);
        return "AdminPanel/Permission/permissions-subCategory";
    }

    @PostMapping("/add/{permissionName}")
    public String addPermissionSubCategory(Model model, @PathVariable("permissionName") String permissionName, @ModelAttribute("permissionSubCategoryDTO") PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        String param = adminPanelPermissionService.addSubCategoryToPermission(permissionName, permissionSubCategoryDTO);
        return "redirect:/auth/permissionsSubCategory/" + permissionName + "?" + param;
    }

    @GetMapping("/delete/{permissionName}/{subCategoryName}")
    public String deletePermissionSubCategory(Model model, @PathVariable("permissionName") String permissionName, @PathVariable("subCategoryName") String subCategoryName) {
        String param = adminPanelPermissionService.deleteSubCategoryFromPermission(subCategoryName);
        return "redirect:/auth/permissionsSubCategory/" + permissionName + "?";
    }

    @GetMapping("/updateSub/{permissionName}/{subCategoryName}")
    public String editPermissionSubCategory(Model model, @PathVariable("permissionName") String permissionName, @PathVariable("subCategoryName") String subCategoryName, @ModelAttribute("permissionSubCategoryDTO") PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        permissionSubCategoryDTO = permissionSubCategoryDTOGetterMapper.apply(permissionSubCategoryRepository.findBySubCategoryName(subCategoryName));
        model.addAttribute("permissionSubCategoryDTO", permissionSubCategoryDTO);

        model.addAttribute("selectedPermissionName", permissionName);
        return "AdminPanel/Permission/permission-subCategory-edit";
    }

    @PostMapping("/updateSub/{permissionName}/{subCategoryName}")
    public String editPermissionSubCategoryPost(Model model, @PathVariable("permissionName") String permissionName, @PathVariable("subCategoryName") String subCategoryName, @ModelAttribute("permissionSubCategoryDTO") PermissionSubCategoryRequestDTO permissionSubCategoryDTO) {
        String param = adminPanelPermissionService.updateSubCategoryFromPermission(subCategoryName, permissionSubCategoryDTO);
        return "redirect:/auth/permissionsSubCategory/" + permissionName + "?" + param;
    }
}
