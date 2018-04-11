package com.example.SpringSecurity.configaration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfigaration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as credentials, true from user where username=? and status="+1)
                .authoritiesByUsernameQuery("select user_username as principal, role_name as role from user_roles where user_username=?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // TODO Auto-generated method stub
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().antMatchers( "/", "/about", "/login", "/css/**", "/js/**").permitAll()
                .antMatchers("/profile").hasAnyRole("REPORT_ADMIN,ADMIN")
                .antMatchers("/users","/addTask","/addReportAdmin").hasAnyRole("ADMIN")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/profile").and().logout().logoutSuccessUrl("/login");
    }
}
