package com.jccf.service;

public class OutputService {

    private final GreetingService greetingService;
    private final TimerService timerService;
    private final String name;

    public OutputService(GreetingService greetingService, TimerService timerService, String name) {
        this.greetingService = greetingService;
        this.timerService = timerService;
        this.name = name;
    }

    public void generateOutput() {
        System.out.printf("%s - %s %s%n", timerService.getTime(), greetingService.getGreeting(), name);
    }
}
