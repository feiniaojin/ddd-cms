package com.feiniaojin.ddd.cms;

import com.feiniaojin.ddd.cms.infrastructure.persitrence.PersistenceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(PersistenceConfig.class)
public class CmsLauncher {
    public static void main(String[] args) {
        SpringApplication.run(CmsLauncher.class, args);
    }
}
