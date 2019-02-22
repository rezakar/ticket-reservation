package com.example.easynotes.repository;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
