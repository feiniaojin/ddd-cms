package com.feiniaojin.ddd.cms.interfaces.web;

import com.feiniaojin.ddd.cms.interfaces.web.exceptions.NotFoundException;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.AbstractExceptionAliasRegisterConfig;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.EnableGracefulResponse;
import com.feiniaojin.ddd.ecosystem.gracefulresponse.ExceptionAliasRegister;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGracefulResponse
public class WebConfig extends AbstractExceptionAliasRegisterConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister register) {
        register.doRegisterExceptionAlias(NotFoundException.class);
    }
}
