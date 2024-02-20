package ru.coldsun.homework12.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * Класс определяющий аспект поведения приложения.
 */
@Component
@Aspect
public class UserActionTrackingAspect {

    @Around("@annotation(ru.coldsun.homework12.aspect.TrackUserAction)")
    public Object trackUserAction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Пользователь вызвал метод "
                + joinPoint.getSignature().getName()  + ".");
        Object proceed = joinPoint.proceed();
        System.out.println("Метод завершил работу.");
        return proceed;
    }
}

