package com.client.newsBlog.controller.adminPanel;

import com.client.newsBlog.dto.adminPanel.request.UserRequestDTO;
import com.client.newsBlog.model.User;
import com.client.newsBlog.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AdminPanelAuthenticationController {
    private final UserRepository userRepository;

    @GetMapping("/login")
    public String loginPage() {
        return "AdminPanel/mise/login_admin";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public String login(Model model, @ModelAttribute("userRequestDTO") UserRequestDTO userRequestDTO) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("Principal: " + principal);
        if(principal instanceof UserDetails) {
            return "redirect:/auth/dashboard";
        }
        if (userRequestDTO.getEmail() == null || userRequestDTO.getEmail().isEmpty()) {
            return "redirect:/auth/login?NoInput";
        }
        return "redirect:/auth/login?loginError";
    }

    @RequestMapping(value = "/logoutUser", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            String userEmail = ((UserDetails) principal).getUsername();
            User user = userRepository.findByEmail(userEmail);
            if(user != null){
                user.setOnlineStatus(false);
                userRepository.save(user);
            }
        }
        HttpSession session = request.getSession();
        session.invalidate();
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(null);
        System.out.println("Logged out");
        return "redirect:/auth/login?logoutSuccess";
    }
}
