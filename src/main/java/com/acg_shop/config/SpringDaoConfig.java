package com.acg_shop.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.spi.SessionFactoryBuilderFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Dao配置
 * Created by mac_zly on 2017/4/18.
 */

@Configuration
@ComponentScan(basePackages = {"com.acg_shop.dao", "com.acg_shop.service"})
@EnableJpaRepositories(basePackages = {"com.acg_shop.dao"}, entityManagerFactoryRef = "entityManagerFactoryBean")
public class SpringDaoConfig {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DruidDataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("Zly123go.");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/acg_db?useUnicode=true&characterEncoding=UTF-8&useSSL=false");

        // 配置初始的链接个数
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxActive(20);
        druidDataSource.setMinIdle(1);

        // 超时时间
        druidDataSource.setMaxWait(60000);

        // 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        // 配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);

        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);

        /*
         * 如果用Oracle，则把poolPreparedStatements配置为true
         * mysql可以配置为false。分库分表较多的数据库，建议配置为false。
         */
        druidDataSource.setPoolPreparedStatements(false);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);

        // 验证连接有效与否的SQL，不同的数据配置不同
        druidDataSource.setValidationQuery("SELECT 'x'");

        try {
            // 配置监控统计拦截的filters
            druidDataSource.setFilters("stat,log4j2");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Filter> filters = new ArrayList<>();
        filters.add(statFilter());
        filters.add(log4j2Filter());
        druidDataSource.setProxyFilters(filters);

        return druidDataSource;
    }

    //
    /*@Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource) {
        return new JdbcTemplate(druidDataSource);
    }*/

    // Spring Data Jpa
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DruidDataSource druidDataSource) {
        LocalContainerEntityManagerFactoryBean e = new LocalContainerEntityManagerFactoryBean();
        e.setDataSource(druidDataSource);
        e.setPackagesToScan("com.acg_shop.entity");
        HibernateJpaVendorAdapter jpaVendorAdaptr = new HibernateJpaVendorAdapter();
        jpaVendorAdaptr.setShowSql(true);
        jpaVendorAdaptr.setGenerateDdl(true);
        e.setJpaVendorAdapter(jpaVendorAdaptr);
        return e;
    }

    @Bean
    public static StatFilter statFilter() {
        StatFilter statFilter = new StatFilter();
        statFilter.setMergeSql(true);
        statFilter.setSlowSqlMillis(10000);
        statFilter.setLogSlowSql(true);
        return statFilter;
    }

    @Bean
    public static Log4j2Filter log4j2Filter() {
        Log4j2Filter log4j2Filter = new Log4j2Filter();
        log4j2Filter.setResultSetLogEnabled(true);
        log4j2Filter.setStatementExecutableSqlLogEnable(true);
        return log4j2Filter;
    }

    // 事务管理
    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(DruidDataSource druidDataSource) {
        return new DataSourceTransactionManager(druidDataSource);
    }
}
