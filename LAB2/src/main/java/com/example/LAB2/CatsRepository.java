package com.example.LAB2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatsRepository
        extends CrudRepository<Cat,Long> {
    public Optional<Cat> findByName(String name);
}
