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

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new  BCryptPasswordEncoder();
    }

    public SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth) ->{
            try {
                auth.requestMatchers("/","/css/**", "/images/**"
                ,"/listar").permitAll()
                        .requestMatchers("/ver/**").hasAnyRole("USER")
                        .requestMatchers("uploads/**").hasAnyRole("USER")
                        .requestMatchers("/form/**").hasAnyRole("ADMIN")
                        .requestMatchers("/eliminar/**").hasAnyRole("ADMIN")
                        .requestMatchers("/factura/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated();

            }catch (Exception e){
                e.printStackTrace();
            }
        } );

        return http.build();
    }

    @Bean
    public UserDetailsService configurerGlobal() throws Exception{
        InMemoryUserDetailsManager manager=  new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin").
                password(passwordEncoder().encode("12345"))
                .roles("ADMIN", "USER").build());

        manager.createUser(User.withUsername("andres").
                password(passwordEncoder().encode("12345"))
                .roles("USER").build());

        return  manager;
    }
}
