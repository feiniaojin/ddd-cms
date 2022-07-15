package com.feiniaojin.ddd.cms.infrastructure.persitrence;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScans({
        @MapperScan(basePackages = {
                "com.feiniaojin.ddd.cms.infrastructure.persitrence.mapper"
        })
})
public class PersistenceConfig {

}
