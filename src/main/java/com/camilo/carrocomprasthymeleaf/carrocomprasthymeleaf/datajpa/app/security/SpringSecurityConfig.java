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


@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {

    /*
    @Autowired
    private DataSource dataSource;*/

    @Autowired
    private LoginSuccessHandler successHandler;

    @Autowired
    private JpaUserDetailService userDetailsService;



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar")
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.successHandler(successHandler)
                        .loginPage("/login").
                        permitAll())
                .logout((logout) -> logout.permitAll())
                //.logout(logout -> logout.permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/error_403"));
        //.httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /*
    @Bean
    public UserDetailsService userDetailsService() throws Exception {

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(  User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                        //.passwordEncoder()
                .roles("ADMIN","USER")
                .build());

        manager.createUser(User.withDefaultPasswordEncoder()
                .username("andres")
                .password("12345")
                       // .passwordEncoder()
                .roles("USER")
                .build());
        return manager;
    }*/

    /*
    @Bean
    public JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> authenticationManager(HttpSecurity http) throws Exception {



        JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> managerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class)
                .jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(autQuery);

        return managerBuilder;
    }*/


    /*


    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
    {
        final  String userQuery = "SELECT usuario as username\n" +
                ",clave as password\n" +
                ",activo as enabled\n" +
                "FROM carrito.dbo.usuario u \n" +
                "WHERE usuario =?";

        final String autQuery = "SELECT u.usuario as username,\n" +
                "a.autorizado as authority \n" +
                "FROM carrito.dbo.autorizaciones a \n" +
                "INNER JOIN carrito.dbo.usuario u \n" +
                "ON u.id = a.idusuario \n" +
                "WHERE u.usuario =?";

        build.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder)
                .usersByUsernameQuery(userQuery)
                .authoritiesByUsernameQuery(autQuery);


    }*/

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

}
