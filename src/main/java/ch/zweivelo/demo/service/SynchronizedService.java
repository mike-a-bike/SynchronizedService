package ch.zweivelo.demo.service;

import ch.zweivelo.demo.rest.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * TODO Comment
 *
 * @author Michael Bieri
 * @since 16.11.16
 */

public class SynchronizedService implements BusinessService {

    private static final Random RANDOM = new Random(Instant.now().getEpochSecond());

    private static final Logger LOGGER = LoggerFactory.getLogger(SynchronizedService.class);

    @Override
    public String method1(String in) {
        synchronized (Controller.class) {
            LOGGER.info(Thread.currentThread().getName() + ": enter method1 in SynchronizedService");
            Instant start = Instant.now();

            delay();

            LOGGER.info(Thread.currentThread().getName() + ": leave method1 in SynchronizedService [" + Duration.between(start, Instant.now()).getSeconds() + "]");

            return in;
        }
    }

    @Override
    public String method2(String in) {
        synchronized (Controller.class) {
            LOGGER.info(Thread.currentThread().getName() + ": enter method2 in SynchronizedService");
            Instant start = Instant.now();

            delay();

            LOGGER.info(Thread.currentThread().getName() + ": leave method2 in SynchronizedService [" + Duration.between(start, Instant.now()).getSeconds() + "]");

            return in;
        }
    }

    private void delay() {
        synchronized (Controller.class) {
            LOGGER.info(Thread.currentThread().getName() + ": enter delay");
            try {
                Thread.sleep(10_000L + RANDOM.nextInt(10) * 1_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LOGGER.info(Thread.currentThread().getName() + ": leave delay");
        }
    }

}
