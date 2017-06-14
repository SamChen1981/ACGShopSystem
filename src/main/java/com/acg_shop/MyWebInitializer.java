package com.acg_shop;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置的开始
  // 测试要加@WebAppConfiguration
  * Created by mac_zly on 2017/4/18.
 */

@Configuration
public class MyWebInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        // 配置类扫描
        context.scan("com.acg_shop.config");
        servletContext.addListener(new ContextLoaderListener(context));

        // 过滤器
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        FilterRegistration.Dynamic filterRegistration = servletContext.addFilter("springEncodingFilter", encodingFilter);
        filterRegistration.setInitParameter("encoding", "UTF-8");
        filterRegistration.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        //XmlWebApplicationContext xmlWebApplicationContext = new XmlWebApplicationContext();
        //context.setConfigLocation("spring/spring-*.xml");

        // Spring注册Servlet
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet",
                new DispatcherServlet(
                        new GenericWebApplicationContext()
                        //xmlWebApplicationContext
                )
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        // druid 配置监测
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistration.Dynamic druidDispatcher = servletContext.addServlet("DruidStatView", statViewServlet);
        Map<String, String> druidParameterMap = new HashMap<>();
        druidParameterMap.put("resetEnable", "true");
        druidParameterMap.put("loginUsername", "sayzly");
        druidParameterMap.put("loginPassword", "Zly123go.");
        druidDispatcher.setInitParameters(druidParameterMap);
        druidDispatcher.addMapping("/druid/*");

        // druid 过滤器
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistration.Dynamic druidFilter = servletContext.addFilter("DruidWebStatFilter", webStatFilter);
        druidFilter.setInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        druidFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

}
