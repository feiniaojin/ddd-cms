package com.feiniaojin.ddd.cms.interfaces.web.exceptions;

import com.feiniaojin.ddd.cms.domain.article.exceptions.NotFoundDomainException;
import com.feiniaojin.gracefulresponse.api.ExceptionAliasFor;

@ExceptionAliasFor(code = "1404", msg = "文章找不到了", aliasFor = NotFoundDomainException.class)
public class NotFoundException extends RuntimeException {
}
