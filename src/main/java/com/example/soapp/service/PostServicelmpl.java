package com.example.soapp.service;

import com.example.soapp.model.Evenement;
import com.example.soapp.model.Post;
import com.example.soapp.repository.EvenementRepository;
import com.example.soapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

@Service
public class PostServicelmpl implements PostService{
    @Autowired
    private PostRepository postRepository;


    public List<Post> getPost(){
        return postRepository.findAll();
    }

    @Override
    public Post creerPost(Post post) {
        Date date = new Date();
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        post.setDateCreation(date);
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> rechercheParId(Long id){
        return postRepository.findById(id);
    }

   /* @Override
    public List<Post> rechercheFeed(){
        return postRepository.rechercheFeed();
    }*/

    @Override
    public List<Post> recherchePourAsso(String nom){
        return postRepository.recherchePourAsso(nom);
    }

    @Override
    public Post modifier(Post post, Long id) {
        return postRepository.findById(id)
                .map(event -> {
                    if(post.getNom() != null){
                        event.setNom(post.getNom());
                    }
                    if(post.getDateCreation() != null){
                        event.setDateCreation(post.getDateCreation());
                    }
                    if(post.getDescription() != null){
                        event.setDescription(post.getDescription());
                    }
                    if(post.getLien() != null){
                        event.setLien(post.getLien());
                    }
                    if(post.getTitre_lien() != null){
                        event.setTitre_lien(post.getTitre_lien());
                    }
                    return postRepository.save(event);
                })
                .orElseThrow(() -> new RuntimeException("Evenement not found"));
    }
    @Override
    public String supprimer(Long id) {
        postRepository.deleteById(id);
        return "Post supprimée";
    }

}
