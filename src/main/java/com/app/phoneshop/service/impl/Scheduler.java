package com.app.phoneshop.service.impl;

import com.app.phoneshop.service.OrderPaidService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private final OrderPaidService orderPaidService;

    public Scheduler(OrderPaidService orderPaidService) {
        this.orderPaidService = orderPaidService;
    }

    @Scheduled(initialDelay = 1000L, fixedDelayString = "${schedule.work}")
    void checkUnpaidOrders() {
        orderPaidService.removeUnpaidOrders();
    }
}
