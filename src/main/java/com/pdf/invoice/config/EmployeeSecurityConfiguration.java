package com.pdf.invoice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class EmployeeSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/fonts/**", "/images/**", "/css/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/").not().authenticated()
        	.antMatchers("/welcome").not().authenticated()
        	.antMatchers("/sendMail").not().authenticated()
        	.antMatchers("/contactus").not().authenticated()
        	.antMatchers("/list").hasAnyRole("USER", "ADMIN")
            .antMatchers("/addEmployeeForm").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/list")
            .permitAll().and().logout().logoutSuccessUrl("/welcome").permitAll();

        http.csrf().disable();
        http
        .headers()
           .defaultsDisabled()
           .cacheControl();
    }
    
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    @Override
    public void configure(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("employee").password(passwordEncoder().encode("employee"))
            .authorities("ROLE_USER").and().withUser("javainuse").password(passwordEncoder().encode("javainuse"))
            .authorities("ROLE_USER", "ROLE_ADMIN");
    }
    

}