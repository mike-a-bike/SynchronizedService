package ch.zweivelo.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * TODO axmbi03: document class here
 *
 * @author axmbi03
 * @since 16.11.2016.
 */
public class StandardHelperService implements HelperService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StandardHelperService.class);
    private static final Random RANDOM = new Random(Instant.now().getEpochSecond());

    @Override
    public String helperMethod(String in) {
        LOGGER.info(Thread.currentThread().getName() + ": enter helperMethod in StandardHelperService");
        Instant start = Instant.now();
        delay();
        LOGGER.info(Thread.currentThread().getName() + ": leave helperMethod in StandardHelperService [" + Duration.between(start, Instant.now()).getSeconds() + "]");
        return in;
    }

    private void delay() {
        LOGGER.info(Thread.currentThread().getName() + ": enter delay");
        try {
            Thread.sleep(10_000L + RANDOM.nextInt(10) * 1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info(Thread.currentThread().getName() + ": leave delay");
    }

}
