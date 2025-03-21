package org.example.ticketservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(TicketServiceApplication.class, args);
        System.out.println("Ticket Service Application Started");
    }

}
