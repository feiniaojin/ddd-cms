package com.feiniaojin.ddd.cms.interfaces.web;

import com.feiniaojin.ddd.cms.interfaces.web.exceptions.NotFoundException;
import com.feiniaojin.gracefulresponse.AbstractCustomConfig;
import com.feiniaojin.gracefulresponse.EnableGracefulResponse;
import com.feiniaojin.gracefulresponse.ExceptionAliasRegister;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGracefulResponse
public class WebConfig extends AbstractCustomConfig {

    @Override
    protected void registerAlias(ExceptionAliasRegister register) {
        super.registerAlias(register);
        register.doRegisterExceptionAlias(NotFoundException.class);
    }
}
