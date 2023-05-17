package com.example.soapp.repository;

import com.example.soapp.model.Admin;
import com.example.soapp.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
}
