package com.jccf.config;

import com.jccf.service.GreetingService;
import com.jccf.service.OutputService;
import com.jccf.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class SpringConfiguration {

    @Value("${app.greeting}")
    private String greeting;
    @Value("${app.name}")
    private String name;
    @Value("#{new Boolean(environment['app.is24'])}")
    private Boolean is24;

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private TimerService timerService;

    @Bean
    public GreetingService gettingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public TimerService timerDevService() {
        return new TimerService(is24);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timerService, name);
    }
}
