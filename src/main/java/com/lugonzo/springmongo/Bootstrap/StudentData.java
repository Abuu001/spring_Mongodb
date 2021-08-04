package com.lugonzo.springmongo.Bootstrap;


import com.lugonzo.springmongo.model.Address;
import com.lugonzo.springmongo.model.Gender;
import com.lugonzo.springmongo.model.Student;
import com.lugonzo.springmongo.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class StudentData {

    @Bean
    CommandLineRunner runner(StudentRepository repository , MongoTemplate mongoTemplate){

        return args -> {
            var address1= Address.builder()
                    .country("Kenya")
                    .city("Nairobi")
                    .postCode("NBI047")
                    .build();

            var student1 = Student.builder()
                    .firstName("Abraham")
                    .lastName("Lugonzo")
                    .email("abramlugonzo@gmail.com")
                    .gender(Gender.MALE)
                    .address(address1)
                    .favouriteSubjects(List.of("Comp science ","Software Engineering","information Technology"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .created(LocalDateTime.now())
                    .build();

            var address2= Address.builder()
                    .country("Uganda")
                    .city("Kampala")
                    .postCode("KM21B")
                    .build();

            var student2 = Student.builder()
                    .firstName("Lizz")
                    .lastName("Shinnah")
                    .email("lizz404@gmail.com")
                    .gender(Gender.FEMALE)
                    .address(address2)
                    .favouriteSubjects(List.of("Crop Protection","Pest control","Animal control"))
                    .totalSpentInBooks(BigDecimal.TEN)
                    .created(LocalDateTime.now())
                    .build();

            var students = List.of(student1,student2);
            repository.insert(students);

            //setting custom methods
         /*   Query query = new Query();
            query.addCriteria(Criteria.where("email").is("abramlugonzo@gmail.com"));

            List<Student> stud= mongoTemplate.find(query,Student.class);

            if(stud.size() > 1){
                throw new IllegalStateException("found many students with email ");
            }

            if(stud.isEmpty()){
                repository.insert(stud);
            }*/

         /*   repository.findStudentByEmail("abramlugonzo@gmail.com")
                    .ifPresentOrElse(s->{
                        System.out.println(s + " already exists");
                    },()->{
                        System.out.println("Inserting document");
                        repository.insert(students);
                    });*/
        };
    }
}
