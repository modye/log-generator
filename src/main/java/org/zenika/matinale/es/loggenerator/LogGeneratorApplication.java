package org.zenika.matinale.es.loggenerator;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

import static java.lang.Thread.sleep;

@SpringBootApplication
@Slf4j
public class LogGeneratorApplication {

    private final static Logger SHOP_LOG = LoggerFactory.getLogger("SHOP");

    /**
     * Main method. <br/>
     * Log random operations every X seconds.
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(LogGeneratorApplication.class, args);
        try {
            while (true) {
                // Sleep a while
                sleep(getRandomBetween(0, 3) * 1000);
                // Do something
                operation(getRandomBetween(1, 10));
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Get a random between two bounds
     *
     * @param min
     * @param max
     * @return
     */
    private static int getRandomBetween(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Run operation
     *
     * @param index
     */
    private static void operation(int index) {

        switch (index) {
            case 1:
                log.info("An operation occured");
                break;
            case 2:
                log.error("ERROR", new RuntimeException("RUNTIME error"));
                break;
            case 3:
                log.warn("A suspicious operation occured");
                break;
            case 4:
                log.info("INFO");
                break;
            case 5:
                log.error("NPE ERROR", new NullPointerException("Fake NPE"));
                break;
            // functional
            case 6:
                SHOP_LOG.info("reservation {} {}", getRandomBetween(1, 10), getRandomBetween(1, 10));
                break;
            case 7:
                SHOP_LOG.info("bon_reduction {} {}", getRandomBetween(1, 10), getRandomBetween(1, 10));
                break;
            case 8:
                SHOP_LOG.info("annulation {} {}", getRandomBetween(1, 10), getRandomBetween(1, 10));
                break;
            case 9:
                SHOP_LOG.info("achat {} {}", getRandomBetween(1, 10), getRandomBetween(1, 10));
                break;
            default:
                log.error("None operation can be found", new UnsupportedOperationException());
        }
    }

}
