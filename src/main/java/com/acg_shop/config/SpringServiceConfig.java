package com.acg_shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Service 配置
 * Created by mac_zly on 2017/5/18.
 */

@Configuration
// 相当于<tx:annotation-driven/>
@EnableTransactionManagement
@ComponentScan({"com.acg_shop.service"})
// TransactionManagementConfigurer -> <tx:annotation-driven transaction-manager="dataSourceTransactionManager"/>
public class SpringServiceConfig implements TransactionManagementConfigurer {

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        try {
            dataSourceTransactionManager.setDataSource(SpringDaoConfig.druidDataSource());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSourceTransactionManager;
    }

    // 事务管理
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return dataSourceTransactionManager();
    }
}
