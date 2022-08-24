package com.myunica.first.test;

import com.myunica.first.service.EventService;
import com.myunica.first.service.OffersService;
import com.myunica.first.service.SessionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class Test {
    private final SessionService sessionService;
    private final OffersService offersService;
    private final EventService eventService;

    @PostConstruct
    private void test() {
        ResponseEntity<?> response = sessionService.startSession(589);
        log.info("\n\n" + response.toString() + "\n");


        response = offersService.getOffers(589, "TrainingIP");
        log.info("\n\n" + response.toString() + "\n");

        response = offersService.getOffersForMultipleIP(589, Arrays.asList("TrainingIP", "TrainingIP"));
        log.info("\n\n" + response.toString() + "\n");

        response = eventService.postEvent(589, List.of("1ed8.d2.4d25fa3.4d25fa3"));
        log.info("\n\n" + response.toString() + "\n");


        response = sessionService.endSession(589);
        log.info("\n\n" + response.toString() + "\n");
    }
}
