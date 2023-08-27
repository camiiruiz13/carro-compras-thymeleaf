package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.security;


import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.comons.auth.handler.LoginSuccessHandler;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.usuarios.JpaUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig {



    @Autowired
    private LoginSuccessHandler sucessHandler;



    @Autowired
    private JpaUserDetailService userDetailSService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailSService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.successHandler(sucessHandler)
                        .loginPage("/login").
                        permitAll())
                .logout((logout) -> logout.permitAll())
                //.logout(logout -> logout.permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/error_403"));
        //.httpBasic(withDefaults());
        return http.build();
    }

}
