package ch.zweivelo.demo.rest;

import ch.zweivelo.demo.service.BusinessService;
import ch.zweivelo.demo.service.HelperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.Instant;

/**
 * TODO Comment
 *
 * @author Michael Bieri
 * @since 16.11.16
 */

@RestController
@RequestMapping("services/v1")
public class Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    private final BusinessService service;
    private final HelperService helperService;

    @Autowired
    public Controller(BusinessService service, HelperService helperService) {
        this.service = service;
        this.helperService = helperService;
    }

    @GetMapping("hello")
    public String sayHello() {
        LOGGER.info(Thread.currentThread().getName() + ": enter method 'sayHello'");
        Instant start = Instant.now();

        final String result = service.method1("hello from thread: " + Thread.currentThread().getName());

        LOGGER.info(Thread.currentThread().getName() + ": leaving method 'sayHello' [" + Duration.between(start, Instant.now()).getSeconds() + "]");
        return result;
    }

    @GetMapping("goodbye")
    public String sayGoodbye() {
        LOGGER.info(Thread.currentThread().getName() + ": enter method 'sayGoodbye'");
        Instant start = Instant.now();

        final String result = service.method2("goodbye from thread: " + Thread.currentThread().getName());

        LOGGER.info(Thread.currentThread().getName() + ": leaving method 'sayGoodbye' [" + Duration.between(start, Instant.now()).getSeconds() + "]");
        return result;
    }

    @GetMapping("help")
    public String helperCall() {
        final String result = helperService.helperMethod("HELP!!!!");
        return result;
    }

    @GetMapping("heartbeat")
    public String heartbeat() {
        return "still here...";
    }

}