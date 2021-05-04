package com.example.homework07.aop;

import com.example.homework07.config.DBContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("(execution(* com.example.homework07.service..*.select*(..)) " +
            "|| execution(* com.example.homework07.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut(" execution(* com.example.homework07.service..*.insert*(..)) " +
            "|| execution(* com.example.homework07.service..*.save*(..)) " +
            "|| execution(* com.example.homework07.service..*.update*(..)) " +
            "|| execution(* com.example.homework07.service..*.edit*(..)) " +
            "|| execution(* com.example.homework07.service..*.delete*(..)) " +
            "|| execution(* com.example.homework07.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }

}
