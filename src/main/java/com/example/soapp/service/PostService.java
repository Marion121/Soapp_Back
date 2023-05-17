package com.example.soapp.service;

import com.example.soapp.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getPost();

    Post creerPost(Post post);

    Optional<Post> rechercheParId(Long id);

    Post modifier(Post evenement, Long id);

    //List<Post> rechercheFeed();

    List<Post> recherchePourAsso( Long id);

    String supprimer(Long id);
}
