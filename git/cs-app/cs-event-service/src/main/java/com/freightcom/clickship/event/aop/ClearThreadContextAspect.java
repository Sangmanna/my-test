package com.freightcom.clickship.event.aop;

import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ClearThreadContextAspect {

    @After("@annotation(ClearThreadContext)")
    public void clearThreadContext() {
        ThreadContext.clearAll();
    }
}