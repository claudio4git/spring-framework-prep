package com.jccf.service;

public class OutputService {

    private final GettingService gettingService;
    private final TimerService timerService;

    public OutputService(GettingService gettingService, TimerService timerService) {
        this.gettingService = gettingService;
        this.timerService = timerService;
    }

    public void generateOutput(String who) {
        System.out.printf("%s - %s %s%n", timerService.getTime(), gettingService.getGetting(), who);
    }
}
