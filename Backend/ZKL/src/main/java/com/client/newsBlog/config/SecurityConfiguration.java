package com.client.newsBlog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/auth/dashboard").permitAll()
                                .requestMatchers("/index/**").permitAll()

//                        .requestMatchers(mvcMatcherBuilder.pattern("/auth/**")).hasRole("ADMIN")

                                .requestMatchers("/assets/**", "/images/**", "/fonts/**",
                                        "/resources/**", "/static/**", "/images",
                                        "/css/**", "/js/**", "/js", "/css").permitAll()

                                .requestMatchers("/boostrapVendor/**", "/boostrapVendor/*...", "/boostrapVendor").permitAll()
        );

        http
                .formLogin(form ->
                        form
                                .loginPage("/auth/loginUser")
                                .successHandler(new RoleBasedAuthenticationSuccessHandler())
                                .failureUrl("/auth/login?loginError")
                                .permitAll()
                );
//                .logout(logout ->
//                        logout
//                                .logoutUrl("/logout")
//                                .logoutSuccessUrl("/auth/login")
//                                .permitAll()
//                );
        http
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/**")));


        return http.build();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
