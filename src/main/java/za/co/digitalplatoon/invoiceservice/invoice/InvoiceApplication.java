package za.co.digitalplatoon.invoiceservice.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class InvoiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(InvoiceApplication.class, args);
    }
}
