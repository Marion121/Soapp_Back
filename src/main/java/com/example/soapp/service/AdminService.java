package com.example.soapp.service;

import com.example.soapp.model.Admin;
import com.example.soapp.model.Etudiant;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    Admin creerAdmin(Admin admin);

    Optional<Admin> rechercheParId(Long id);

    List<Admin> getEtudiant();

    String supprimer(Long id);

    Admin modifier(Admin admin, Long id);
}
