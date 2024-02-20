package ru.coldsun.homework12.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.coldsun.homework12.aspect.UserActionTrackingAspect;

@Configuration
@ComponentScan(basePackages = "ru.coldsun")
@EnableAspectJAutoProxy
public class ProjectConfiguration {
    @Bean
    public UserActionTrackingAspect aspect(){
        return new UserActionTrackingAspect();
    }
}
