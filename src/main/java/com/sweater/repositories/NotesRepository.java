package com.sweater.repositories;

import com.sweater.entities.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface NotesRepository extends JpaRepository<Notes, Integer> {

}