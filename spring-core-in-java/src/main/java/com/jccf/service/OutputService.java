package com.jccf.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimerService timerService;

    public OutputService(GreetingService greetingService, TimerService timerService) {
        this.greetingService = greetingService;
        this.timerService = timerService;
    }

    public void generateOutput(String who) {
        System.out.printf("%s - %s %s%n", timerService.getTime(), greetingService.getGreeting(), who);
    }
}
