package com.acg_shop.config;

import com.acg_shop.filter.BaseFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * config
 * Created by mac_zly on 2017/4/18.
 */

// 等同于<mvc:annotation-driven/>
@EnableWebMvc
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"com.acg_shop.controller", "com.acg_shop.aspect", "com.acg_shop.handle"})
public class SpringWebConfig extends WebMvcConfigurerAdapter {

    // ============= FreeMarker ====================
    @Bean
    public FreeMarkerViewResolver freeMarkerViewResolver() {
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setCache(false);
        //resolver.setPrefix("");
        //resolver.setViewNames("/*");
        resolver.setSuffix(".html");
        resolver.setOrder(1);
        resolver.setContentType("text/html;charset=UTF-8");

        resolver.setExposeRequestAttributes(true);
        resolver.setExposeSessionAttributes(true);
        resolver.setExposeSpringMacroHelpers(true);
        resolver.setRequestContextAttribute("request");
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        freeMarkerConfigurer.setDefaultEncoding("UTF-8");

        Properties properties = new Properties();
        properties.setProperty("template_update_delay", "10");
        properties.setProperty("locale", "zh_CN");
        properties.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        properties.setProperty("date_format", "yyyy-MM-dd");
        freeMarkerConfigurer.setFreemarkerSettings(properties);

        return freeMarkerConfigurer;
    }

    // ============= Jsp ====================
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver("/WEB-INF/Views/", ".jsp");
        viewResolver.setOrder(2);
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setViewNames("jsp/*");
        return viewResolver;
    }

    //  json
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>(1);
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);
        converters.add(converter);
    }

    // 配置静态资源的处理,对于静态文件转发给Servlet容器中默认的Servlet处理，而不是Spring的DispatcherServlet来处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    // ============= 拦截器 ====================
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BaseFilter());
    }
}
