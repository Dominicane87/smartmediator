package stc21.smartmediator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    //public static AnnotationConfigApplicationContext ctx =
    //        new AnnotationConfigApplicationContext(ApplicationConfig.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ApplicationContext ctx) {

        return args -> System.out.println("Hello from Smart Mediator.");
    }
}
