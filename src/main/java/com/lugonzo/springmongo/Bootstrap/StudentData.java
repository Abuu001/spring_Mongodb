package com.lugonzo.springmongo.Bootstrap;


import com.lugonzo.springmongo.model.Address;
import com.lugonzo.springmongo.model.Gender;
import com.lugonzo.springmongo.model.Student;
import com.lugonzo.springmongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Configuration
public class StudentData {

    @Bean
    CommandLineRunner runner(StudentRepository repository){

        return args -> {
            var address1= Address.builder()
                    .country("Kenya")
                    .city("Nairobi")
                    .postCode("NBI047")
                    .build();

            var student = Student.builder()
                    .firstName("Abraham")
                    .lastName("Lugonzo")
                    .email("abramlugonzo@gmail.com")
                    .gender(Gender.MALE)
                    .address(address1)
                    .favouriteSubjects(List.of("Comp science ","Software Engineering","information Technology"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .created(LocalDateTime.now())
                    .build();

            repository.insert(student);
        };
    }
}
