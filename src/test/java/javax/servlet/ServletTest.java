package javax.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        return ResponseEntity.ok("Hello, it is " + DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(LocalDateTime.now()));
    }
}
