package dev.runje.jpapaging.repository;

import dev.runje.jpapaging.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepositery extends PagingAndSortingRepository<Person, Integer> {

}
