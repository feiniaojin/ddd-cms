package com.feiniaojin.ddd.cms.infrastructure.persitrence;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@MapperScans({
        @MapperScan(basePackages = {
                "com.feiniaojin.ddd.cms.infrastructure.persitrence.article.mapper"
        })
})
@EnableJdbcAuditing
@EnableJdbcRepositories(basePackages = "com.feiniaojin.ddd.cms.infrastructure.persitrence.article.jdbc")
public class PersistenceConfig {

}
