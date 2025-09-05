package javax.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication(proxyBeanMethods = false)
@RestController
@SuppressWarnings("deprecation")
public class ServletTest {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    public static void main(String... arguments) {
        SpringApplication.run(MethodHandles.lookup().lookupClass(), arguments);
    }

    @GetMapping
    public ResponseEntity<String> hi() throws Exception {
        final var random = ThreadLocalRandom.current().nextDouble();
        if (random < 0.8D) {
            return ResponseEntity.ok("Hello, it is " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
        } else {
            throw new RuntimeException("Oops: " + random);
        }
    }

    @RestControllerAdvice
    private static class Advice {
        @ExceptionHandler
        public ResponseEntity<?> error(Exception exception) {
            try {
                return ResponseEntity
                    .internalServerError()
                    .body(exception);
            } finally {
                exception.printStackTrace(System.err);
            }
        }
    }
}
