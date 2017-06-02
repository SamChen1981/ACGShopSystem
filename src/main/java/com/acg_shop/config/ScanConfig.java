package com.acg_shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 扫面当前包下需要自动装配的属性
 * Created by mac_zly on 2017/6/2.
 */

@Configuration
@ComponentScan // 默认扫描当前所在的包
public class ScanConfig {
}
