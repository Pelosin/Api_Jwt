package com.jwt.test.demo.config.security;

import com.jwt.test.demo.config.security.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final CustomAuthorizationFilter customAuthorizationFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
//        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
//        http.cors().and()
//                .authorizeRequests()
//                .antMatchers("/api/order/all").hasRole("ADMIN")
//                .antMatchers("/ws-order/**").permitAll()
//                .antMatchers("/api/login/**", "/api/user/save", "/api/table", "/sendOrder", "/topic/order",
//                        "/ws-order/**", "/app").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf().disable();




        http.csrf().disable();
//        http.cors();
        http.cors();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.authorizeRequests().antMatchers("/api/**").permitAll();
//        http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests().antMatchers("/api/order/all", "/api/table/all").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/api/login/**", "/api/user/save", "/api/table", "/sendOrder", "/topic/order", "/ws-order/**", "/app").permitAll()
                .anyRequest().authenticated();
//        http.authorizeRequests().antMatchers("/api/order").permitAll();
//        http.authorizeRequests().antMatchers("/api/food/**").permitAll();
//       //http.authorizeRequests().antMatchers(GET, "/api/users").hasAnyAuthority("ROLE_MANAGER");
//        http.authorizeRequests().antMatchers(GET, "/api/users").hasAnyAuthority("MANAGER");
//        http.authorizeRequests().antMatchers(POST, "/role/addtouser").hasAnyAuthority("ROLE_ADMIN");
//        http.authorizeRequests().anyRequest().authenticated();
//        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration configuration = new CorsConfiguration();
        configuration.setExposedHeaders(Arrays.asList("Authorization"));
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
        configuration.addAllowedHeader("*");
        configuration.applyPermitDefaultValues();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }
}
