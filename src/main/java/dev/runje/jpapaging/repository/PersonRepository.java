package dev.runje.jpapaging.repository;

import dev.runje.jpapaging.model.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
