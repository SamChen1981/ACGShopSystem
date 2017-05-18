package com.acg_shop.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4j2Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Dao配置
 * Created by mac_zly on 2017/4/18.
 */

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.acg_shop.dao"})
public class SpringDaoConfig {

    @Bean
    public static DruidDataSource druidDataSource() throws Exception {
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

        //
        druidDataSource.setFilters("stat,log4j2");

        List<Filter> filters = new ArrayList<Filter>();
        filters.add(statFilter());
        filters.add(log4j2Filter());
        druidDataSource.setProxyFilters(filters);

        return druidDataSource;
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

    @Bean
    public static SqlSessionFactoryBean sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 设置数据源
        sqlSessionFactoryBean.setDataSource(druidDataSource());
        // 设置mybatis数据
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        Resource resource = new InputStreamResource(inputStream);
        sqlSessionFactoryBean.setConfigLocation(resource);

        // 设置别名 好像在mybatis中也设置了
        sqlSessionFactoryBean.setTypeAliasesPackage("com.acg_shop.entity");
        // 设置Mapper
        /*Resource[] resources = new Resource[]{
                new InputStreamResource(Resources.getResourceAsStream("mapper/GoodsMapper.xml"))
        };*/
        // 资源扫描
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        return sqlSessionFactoryBean;
    }

    // 配置扫描DAO接口包, 动态实现DAO接口,注入到spring容器中
    @Bean
    public static MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage("com.acg_shop.dao");
        return mapperScannerConfigurer;
    }

}
