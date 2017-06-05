package org.zenika.matinale.es.loggenerator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

import static java.lang.Thread.sleep;

@SpringBootApplication
@Slf4j
public class LogGeneratorApplication {

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
                operation(getRandomBetween(1, 6));
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
            default:
                log.error("None operation can be found", new UnsupportedOperationException());
        }
    }
}
