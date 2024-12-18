package com.client.newsBlog.controller.adminPanel;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AdminPanelController {
    @GetMapping("/dashboard")
    public String getAdminPanel() {
        return "AdminPanel/mise/admin-dashboard";
    }
}
