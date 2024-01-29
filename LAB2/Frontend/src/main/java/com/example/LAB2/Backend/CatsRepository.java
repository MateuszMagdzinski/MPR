package com.example.LAB2.Backend;

import com.example.LAB2.Backend.Cat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatsRepository
        extends CrudRepository<Cat,Long> {
    public Optional<Cat> findByName(String name);
}
