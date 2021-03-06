package com.heqing.mybatis.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author heqing
 * @since 2021-07-21
 */
@Configuration
@PropertySource("classpath:mapper.properties")
@Data
public class MapperProperty {

    @Value("${typeAliasesPackage}")
    private String typeAliasesPackage;

    @Value("${mapperLocations}")
    private String mapperLocations;
}
