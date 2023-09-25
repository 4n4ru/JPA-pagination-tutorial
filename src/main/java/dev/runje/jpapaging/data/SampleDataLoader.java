package dev.runje.jpapaging.data;

import dev.runje.jpapaging.model.Address;
import dev.runje.jpapaging.model.Person;
import dev.runje.jpapaging.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleDataLoader implements CommandLineRunner {

  private final Logger logger = LoggerFactory.getLogger(SampleDataLoader.class);
  private final PersonRepository repository;

  public SampleDataLoader(PersonRepository repository){
    this.repository = repository;
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("Loading Sample Data...");
    Person person = new Person("Ana",
                               "Runje",
                               "000.000.0000",
                               "email@email.com",
                               new Address("Steet", "City", "State", "Zip"));

    repository.save(person);

  }
}
