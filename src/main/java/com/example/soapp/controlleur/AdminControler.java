package com.example.soapp.controlleur;

import com.example.soapp.model.Admin;
import com.example.soapp.model.Etudiant;
import com.example.soapp.service.AdminService;
import com.example.soapp.service.EtudiantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminControler {


    @Autowired
    private AdminService adminService;

    @PostMapping
    @ApiOperation(value = "Creation d'un admin",
            notes = "Cette methode permet de creer un admin")
    public Admin creerAdmin(@RequestBody Admin admin) {
        return adminService.creerAdmin(admin);
    }

    @GetMapping
    @ApiOperation(value = "Recherche par id",
            notes = "Cette methode recherche un admin en fonction de son id")
    public Optional<Admin> research(@RequestParam("id") Long id) {
        return adminService.rechercheParId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Retourne toutes les admins",
            notes = "Cette methode permet de rechercher toutes les admins")
    public List<Admin> getAllAdmin() {
        return adminService.getEtudiant();
    }

    @PatchMapping
    @ApiOperation(value = "Modification d'un admin",
            notes = "Cette methode permet de modifier un admin")
    public Admin modifier(@RequestBody Admin admin, @RequestParam("id") Long id) {
        return adminService.modifier(admin, id);
    }
    @DeleteMapping
    @ApiOperation(value = "Suppression d'une admin",
            notes = "Cette methode permet de supprimer un admin")
    public String supprimer(@RequestParam("id") Long id) {
        return adminService.supprimer(id);
    }
}
