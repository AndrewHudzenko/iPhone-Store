package com.app.phoneshop.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register", "/inject").permitAll()
                .antMatchers(HttpMethod.GET, "/products").hasAnyRole("CLIENT", "MANAGER")
                .antMatchers(HttpMethod.POST, "/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.DELETE, "/products/{id}").hasRole("MANAGER")
                .antMatchers(HttpMethod.PUT, "/products").hasRole("MANAGER")
                .antMatchers(HttpMethod.GET, "/shopping-carts/by-user").hasAnyRole("CLIENT", "MANAGER")
                .antMatchers(HttpMethod.POST, "/shopping-carts/products").hasAnyRole("CLIENT", "MANAGER")
                .antMatchers(HttpMethod.GET,"/orders").hasAnyRole("CLIENT", "MANAGER")
                .antMatchers(HttpMethod.POST,"/orders/complete").hasRole("CLIENT")
                .antMatchers(HttpMethod.DELETE, "/products/{id}").hasAnyRole("CLIENT", "MANAGER")
                .antMatchers(HttpMethod.GET,"/users/by-email").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
