package com.souq.shop.config;

import com.souq.shop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurity extends WebSecurityConfigurerAdapter {
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/register/**", "/", "home", "/category/**", "/product/**", "/cart/**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
//                .loginPage("")
//                .defaultSuccessUrl("/home")
//                .successForwardUrl("/home")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll().deleteCookies("JSESSIONID")
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("accessDenied")
        ;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider
                =new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
         provider.setPasswordEncoder(bCryptPasswordEncoder);
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
