package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig  extends WebSecurityConfigurerAdapter
{
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .httpBasic()
                .and()
                .authorizeRequests()

                .antMatchers("/user").permitAll()
                .antMatchers(HttpMethod.POST,"/user").permitAll()

                .antMatchers(HttpMethod.GET, "/product**").permitAll()
                .antMatchers(HttpMethod.POST, "/product**").hasAuthority("seller")
                .antMatchers(HttpMethod.PUT, "/product**").hasAuthority("seller")
                .antMatchers(HttpMethod.DELETE, "/product**").hasAuthority("seller")

                .antMatchers("/deposit**").hasAuthority("buyer")
                .antMatchers(HttpMethod.DELETE, "/deposit").hasAuthority("buyer")

                .antMatchers("/buy").hasAuthority("buyer")

                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
