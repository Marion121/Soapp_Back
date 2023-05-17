package com.example.soapp.repository;


import com.example.soapp.model.Association;
import com.example.soapp.model.Evenement;
import com.example.soapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {

    @Query(value = "SELECT post.id,post.association_id, post.nom,post.date_creation, post.description, post.lien, post.titre_lien" +
            " FROM post  " +
            "WHERE post.association_id = :id", nativeQuery = true)
    public abstract List<Post> recherchePourAsso(Long id);
}
