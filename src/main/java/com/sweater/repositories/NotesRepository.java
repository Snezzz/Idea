package com.sweater.repositories;

import com.sweater.entities.Notes;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NotesRepository extends CrudRepository<Notes, Integer> {

}