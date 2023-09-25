package dev.runje.jpapaging.data;

import com.github.javafaker.Faker;
import dev.runje.jpapaging.model.Address;
import dev.runje.jpapaging.model.Person;
import dev.runje.jpapaging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
  private final Faker faker;
  private final PersonRepository repository;

  public SampleDataLoader(PersonRepository repository, Faker faker){
    this.repository = repository;
    this.faker = faker;
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Loading Sample Data...");

//    Create 100 rows of people in the database
    List<Person> people = IntStream.rangeClosed(1, 100)
            .mapToObj(i -> new Person(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.phoneNumber().phoneNumber(),
                faker.internet().emailAddress(),
                new Address(
                    faker.address().streetAddress(),
                    faker.address().city(),
                    faker.address().state(),
                    faker.address().zipCode()
                )
            ))
            .toList();

    repository.saveAll(people);

  }
}
