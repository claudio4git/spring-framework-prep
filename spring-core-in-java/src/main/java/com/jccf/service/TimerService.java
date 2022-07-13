package com.jccf.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimerService {

    private final Boolean is24;

    public TimerService(Boolean is24) {
        this.is24 = is24;
    }

    public String getTime() {
        LocalDateTime time = LocalDateTime.now();
        var pattern = is24 ? "d/M/yyyy H:m" : "d/M/yyyy h:m a";
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }
}
