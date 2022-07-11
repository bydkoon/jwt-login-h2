package com.es.api.config.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private final JwtTokenProvider jwtTokenProvider;

    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;


    public SecurityConfig(JwtTokenProvider jwtTokenProvider,
                          JwtAccessDeniedHandler jwtAccessDeniedHandler,
                          JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/css/**, /static/js/**, *.ico");

        // swagger
        web.ignoring().antMatchers(
                "/v2/api-docs", "/v3/api-docs", "/configuration/ui",
                "/swagger-resources", "/configuration/security",
                "/swagger-ui/index.html", "/webjars/**", "/swagger/**","/swagger-resources",
                "/configuration/security", "/swagger-resources/configuration/ui",
                "/swagger-resources/configuration/security", "/h2-console/**","/api/signup","/api/signin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //스프링시큐리티에서 만들어주는 로그인 페이지를 미사용
        http.headers().frameOptions().disable();

        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling()
                //JwtAuthentication exception handling
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                //access Denial handler
                .accessDeniedHandler(jwtAccessDeniedHandler);
    }
}