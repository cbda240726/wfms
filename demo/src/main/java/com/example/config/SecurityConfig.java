package com.example.workforcemanagement.config;

import org.springframework.context.*;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticatonManagerBuilder auth ) throws Exception {
        auth.inMemoryAuthenctication()
                .withUser("admin").password("{noop}password").roles("ADMIN")
                .and()
                .withUser("user").password("{noop}password").roles("USER")
    }
    @Override
    protected void configure(HttpSecurity http ) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .anyMatchers("/admin/**").hasRole("ADMIN")
                .anyMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }
}