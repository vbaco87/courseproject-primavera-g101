package com.primavera.CoursProject.application.security;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.primavera.CoursProject.application.security.jwt.JwtConfig;
import com.primavera.CoursProject.application.security.jwt.JwtTokenVerifierFilter;
import com.primavera.CoursProject.application.security.jwt.JwtUsernamePasswordAuthenticationFilter;
import javax.sql.DataSource;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    private static final String USERS_QUERY = "select email, password, enabled from users where email = ?";
    private static final String AUTHORITIES_QUERY = "select email, role from authorities where email = ?";

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
		        .cors().and()
		        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		        .and()
		        .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig))
		        .addFilterAfter(new JwtTokenVerifierFilter(jwtConfig),JwtUsernamePasswordAuthenticationFilter.class)

                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/users/purchaseBitcoins", "/api/users/soldBitcoins").hasRole("ADMIN")
                .antMatchers("/api/auctions").hasAnyRole("ADMIN", "BIDDER")
                .antMatchers("/api/users/me/buyBitcoins", "api/users/me/auctions", "/api/users/me/purchasedBitcoins", "/api/users/me/soldBitcoins").hasAnyRole("ADMIN", "BROKER")

                .anyRequest()
                .authenticated();

		        
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