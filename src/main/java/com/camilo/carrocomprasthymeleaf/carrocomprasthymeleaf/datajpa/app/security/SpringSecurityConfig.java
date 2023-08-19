package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
    /*
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((authz) -> authz
                                .requestMatchers("/",  "/css/**", "/js/**",
                                        "/images/**", "/listar").permitAll()
                        .requestMatchers("/ver/**").hasAnyRole("USER")
                        .requestMatchers("/uploads/**").hasAnyRole("USER")
                        .requestMatchers("/form/**").hasAnyRole("ADMIN")
                        .requestMatchers("/eliminar/**").hasAnyRole("ADMIN")
                        .requestMatchers("/factura/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated()
                ).formLogin(form -> form//.successHandler(successHandler)
                        .loginPage("/login")
                        .permitAll())
                .logout((logout) -> logout.permitAll()).
                exceptionHandling(acces -> acces.accessDeniedPage("/error_403"));

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(  User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .roles("ADMIN","USER")
                .build());

        manager.createUser(User.withDefaultPasswordEncoder()
                .username("andres")
                .password("12345")
                .roles("USER")
                .build());
        return manager;
    }


}
