package com.client.newsBlog;

import com.client.newsBlog.model.Permissions;
import com.client.newsBlog.model.Role;
import com.client.newsBlog.model.User;
import com.client.newsBlog.repository.PermissionsRepository;
import com.client.newsBlog.repository.RoleRepository;
import com.client.newsBlog.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@EnableConfigurationProperties
public class News_Blog_Application {

	public static void main(String[] args) {
		SpringApplication.run(News_Blog_Application.class, args);
	}

	@Bean
	CommandLineRunner run(PermissionsRepository permissionsRepository,
						  RoleRepository roleRepository, UserRepository userRepository,
						  PasswordEncoder passwordEncoder) {
		return args -> {
			createPermission(permissionsRepository);
			Role adminRole = roleRepository.findByRoleName("ADMIN");
			if(adminRole != null){
				System.out.println("*** Admin already exists ***");
				return;
			}
			System.out.println("*** Added admin with Email: 'admin@admin.com' and password 'admin' ***");
			adminRole = new Role("ADMIN");
			roleRepository.save(adminRole);

			String password = passwordEncoder.encode("admin");
			User adminUser = new User("Admin", "admin@admin.com", password, "ADMIN");
			userRepository.save(adminUser);
		};
	}

	private void createPermission(PermissionsRepository permissionsRepository) {
        Permissions permissions_role = permissionsRepository.findPermissionsByPermissionName("Role");
        if (permissions_role == null) {
			permissions_role = new Permissions();
			permissions_role.setPermissionName("Role");
			permissions_role.setURL("/auth/role");
			permissions_role.setHasSubCategory(true);
            permissionsRepository.save(permissions_role);
			System.out.println("*** Role Permission Created ***");
        }
    }

}
