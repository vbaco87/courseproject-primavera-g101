package com.primavera.CoursProject.application.security;

import cat.tecnocampus.rooms.configuration.security.jwt.JwtConfig;
import cat.tecnocampus.rooms.configuration.security.jwt.JwtTokenVerifierFilter;
import cat.tecnocampus.rooms.configuration.security.jwt.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private static final String USERS_QUERY = "select name, password, enabled from student where name = ?";
    private static final String AUTHORITIES_QUERY = "select username, role from authorities where username = ?";

    private DataSource dataSource;

    private final JwtConfig jwtConfig;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, DataSource dataSource, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/auctions", "/users/**/auctions").hasRole("BIDDER")
                .antMatchers("/users/**/buyBitcoins", "/users/**/auctions", "/users/**/purchasedBitcoins", "/users/**/soldBitcoins").hasRole("BROKER")
                .antMatchers("/api/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }

    // users/me
    //Configure authentication manager
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                .passwordEncoder(passwordEncoder);
    }

}


// SECURITY IT'S ABOUT AUTENTICATION AND AUTHORITATION