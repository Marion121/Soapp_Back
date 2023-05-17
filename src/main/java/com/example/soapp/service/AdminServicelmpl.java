package com.example.soapp.service;

import com.example.soapp.model.Admin;
import com.example.soapp.model.Etudiant;
import com.example.soapp.repository.AdminRepository;
import com.example.soapp.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@RestController
@Service
@AllArgsConstructor
public class AdminServicelmpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;
    public Admin creerAdmin(Admin admin) {
        TimeZone.setDefault( TimeZone.getTimeZone("GMT"));
        return adminRepository.save(admin);
    }
    @Override
    public List<Admin> getEtudiant(){
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> rechercheParId(Long id){
        return adminRepository.findById(id);
    }

    @Override
    public Admin modifier(Admin admin, Long id) {
        return adminRepository.findById(id)
                .map(newAdmin-> {
                    if(admin.getNom() != null){
                        newAdmin.setNom(admin.getNom());
                    }
                    if(admin.getPrenom()!= null){
                        newAdmin.setPrenom(admin.getPrenom());
                    }
                    if(admin.getRole() != null){
                        newAdmin.setRole(admin.getRole());
                    }
                    if(admin.getMdp() != null){
                        newAdmin.setMdp(admin.getMdp());
                    }
                    if(admin.getMail() != null){
                        newAdmin.setMail(admin.getMail());
                    }
                    return adminRepository.save(newAdmin);
                })
                .orElseThrow(() -> new RuntimeException("Etudiant not found"));
    }


    @Override
    public String supprimer(Long id) {
        adminRepository.deleteById(id);
        return "admin supprimée";
    }
}
