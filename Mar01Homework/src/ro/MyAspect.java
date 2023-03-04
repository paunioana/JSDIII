package ro;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class MyAspect {
    @Pointcut("execution(* *run())")
    private void anyRunMethod() {}

    @After(value = "anyRunMethod()", argNames = "joinPoint")
    public void afterCall(JoinPoint joinPoint) {
        System.out.println("Method Name: " + joinPoint.getSignature().toShortString());
    }
}
