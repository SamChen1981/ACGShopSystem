package com.acg_shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 事务管理
 * Created by mac_zly on 2017/6/2.
 */

// TransactionManagementConfigurer -> 相当于
// <tx:annotation-driven transaction-manager="dataSourceTransactionManager"/>

@Configuration
public class TransationManageConfig implements TransactionManagementConfigurer {

    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return dataSourceTransactionManager;
    }
}
