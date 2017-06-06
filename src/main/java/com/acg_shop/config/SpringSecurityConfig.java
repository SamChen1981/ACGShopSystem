package com.acg_shop.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringSecurityConfig
 * Created by mac_zly on 2017/6/5.
 */

//@Configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DruidDataSource druidDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("zly").password("zly123go").roles("User").and()
                .withUser("admin").password("zly123go").roles("Admin");*/
        auth.jdbcAuthentication().dataSource(druidDataSource)
                .usersByUsernameQuery("")
                .authoritiesByUsernameQuery("");
        //.passwordEncoder();
    }

}
