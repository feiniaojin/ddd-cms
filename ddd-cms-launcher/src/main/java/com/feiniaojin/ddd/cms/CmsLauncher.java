package com.feiniaojin.ddd.cms;

import com.feiniaojin.ddd.cms.infrastructure.persitrence.PersistenceConfig;
import com.feiniaojin.ddd.cms.interfaces.web.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PersistenceConfig.class, WebConfig.class})
public class CmsLauncher {
    public static void main(String[] args) {
        SpringApplication.run(CmsLauncher.class, args);
    }
}
