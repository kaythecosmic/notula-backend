package com.thecosmickay.backend_notula.repository;

import com.thecosmickay.backend_notula.entity.NotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NotesEntity, Long> {
}
