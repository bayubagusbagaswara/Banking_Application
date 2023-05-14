package com.bbb.bankingapplication;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
public class DateTimeTests {

//    2023-04-27 13:18:30.000000


    @Test
    void dateTimeTests() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Instant instant = Instant.now();
        LocalDate localDate = LocalDate.now();

        System.out.println(localDateTime);
        System.out.println(instant);
        System.out.println(localDate);
    }
}
