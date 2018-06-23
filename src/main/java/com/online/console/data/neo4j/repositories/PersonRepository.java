package com.online.console.data.neo4j.repositories;


import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.online.console.data.neo4j.domain.Person;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    Person findByName(String name);

}