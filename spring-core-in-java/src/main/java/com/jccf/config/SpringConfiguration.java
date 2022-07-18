package com.jccf.config;

import com.jccf.service.GreetingService;
import com.jccf.service.OutputService;
import com.jccf.service.TimerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    @Value("Hello there")
    private String greeting;

    @Autowired
    private GreetingService greetingService;
    @Autowired
    private TimerService timerService;

    @Bean
    public GreetingService gettingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public TimerService timerService() {
        return new TimerService(false);
    }

    @Bean
    public OutputService outputService() {
        return new OutputService(greetingService, timerService);
    }
}
