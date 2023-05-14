package com.example.soapp.service;

import com.example.soapp.repository.EvenementRepository;
import com.example.soapp.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServicelmpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public String supprimer(Long id) {
        postRepository.deleteById(id);
        return "Post supprimée";
    }

}
