package com.client.newsBlog.controller.adminPanel;
import com.client.newsBlog.dto.adminPanel.request.PermissionRequestDTO;
import com.client.newsBlog.service.adminPanel.adminPanelInterfaces.AdminPanelPermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth/permissions")
@RequiredArgsConstructor
public class  AdminPanelPermissionController {
    private final AdminPanelPermissionService adminPanelPermissionService;

    @GetMapping("")
    public String showAllPermissions(Model model) {
        model.addAttribute("permissionDTOList", adminPanelPermissionService.getAllPermissions());
        return "AdminPanel/Permission/permissions-list";
    }

    @GetMapping("/add")
    public String addPermission(Model model, @ModelAttribute("permissionDTO") PermissionRequestDTO permissionDTO) {
        return "AdminPanel/Permission/permissions-add";
    }

    @PostMapping("/add")
    public String addPermissionPost(Model model, @ModelAttribute("permissionDTO") PermissionRequestDTO permissionDTO) {
        String param = adminPanelPermissionService.addPermission(permissionDTO);
        return "redirect:/auth/permissions?" + param;
    }

    @GetMapping("/delete/{permissionName}")
    public String deletePermissionPost(Model model, @PathVariable("permissionName") String permissionName) {
        String param = adminPanelPermissionService.deletePermission(permissionName);
        return "redirect:/auth/permissions?" + param;
    }

    @GetMapping("/update/{permissionName}")
    public String updatePermission(Model model,@PathVariable("permissionName") String permissionName, @ModelAttribute("permissionDTO") PermissionRequestDTO permissionDTO) {
        permissionDTO = adminPanelPermissionService.getAllPermissions().stream().filter(permission -> permission.getPermissionName().equals(permissionName)).findFirst().orElse(null);
        model.addAttribute("permissionDTO", permissionDTO);
        return "AdminPanel/Permission/permissions-edit";
    }

    @PostMapping("/update/{permissionName}")
    public String updatePermissionPost(Model model,@PathVariable("permissionName") String permissionName, @ModelAttribute("permissionDTO") PermissionRequestDTO permissionDTO) {
        String param = adminPanelPermissionService.updatePermission(permissionName, permissionDTO);
        return "redirect:/auth/permissions?" + param;
    }
}
