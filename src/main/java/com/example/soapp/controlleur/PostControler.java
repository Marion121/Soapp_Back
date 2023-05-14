package com.example.soapp.controlleur;

import com.example.soapp.model.Evenement;
import com.example.soapp.model.Post;
import com.example.soapp.service.PostService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
public class PostControler {

    @Autowired
    private PostService postService;

    @GetMapping()
    @ApiOperation(value = "Recherche un post par id",
            notes = "Cette methode permet de rechercher un post pour un id donne")
    public Optional<Post> rechercheParId(@RequestParam("id") Long id) {
        return postService.rechercheParId(id);
    }

    @GetMapping("/all")
    @ApiOperation(value = "Recherche de tous les posts",
            notes = "Cette methode permet de rechercher tous les posts")
    public List<Post> getPost() {
        return postService.getPost();
    }

    @PostMapping
    @ApiOperation(value = "Creation d'un post",
            notes = "Cette methode permet de creer un post")
    public Post creerPost(@RequestBody Post post) {
        return postService.creerPost(post);
    }

    /*@GetMapping("/feed")
    @ApiOperation(value = "Recherche les posts pour Feed",
            notes = "Cette methode permet de rechercher tous les posts pour le feed")
    public List<Post> rechercheFeed() {
        return postService.rechercheFeed();
    }*/

    @GetMapping("/asso")
    @ApiOperation(value = "Recherche les posts pour une asso",
            notes = "Cette methode permet de rechercher tous les posts pour une asso")
    public List<Post> recherchePourAsso(String nom) {
        return postService.recherchePourAsso(nom);
    }

    @PatchMapping
    @ApiOperation(value = "Modification d'un post",
            notes = "Cette methode permet de modifier un post")
    public Post modifier(@RequestBody Post post, @RequestParam("id") Long id) {
        return postService.modifier(post, id);
    }

    @DeleteMapping
    @ApiOperation(value = "Suppression d'une post",
            notes = "Cette methode permet de supprimer un post")
    public String supprimer(@RequestParam("id") Long id) {return postService.supprimer(id);}


}
