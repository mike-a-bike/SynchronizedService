package ch.zweivelo.demo.config;

import ch.zweivelo.demo.service.BusinessService;
import ch.zweivelo.demo.service.HelperService;
import ch.zweivelo.demo.service.StandardBusinessService;
import ch.zweivelo.demo.service.StandardHelperService;
import ch.zweivelo.demo.service.SynchronizedHelperService;
import ch.zweivelo.demo.service.SynchronizedService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * TODO Comment
 *
 * @author Michael Bieri
 * @since 16.11.16
 */

@Configuration
public class SpringConfig {

    @Bean
    @Profile("SYNC")
    public BusinessService synchronizedBusinessService() {
        return new SynchronizedService();
    }

    @Bean
    @Profile("!SYNC")
    public BusinessService standardBusinessService() {
        return new StandardBusinessService();
    }

    @Bean
    @Profile("SYNC")
    public HelperService synchronizedHelperServie() {
        return new SynchronizedHelperService();
    }

    @Bean
    @Profile("!SYNC")
    public HelperService standardHelperServie() {
        return new StandardHelperService();
    }

}