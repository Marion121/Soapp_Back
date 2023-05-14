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

    /*@Query(value = "SELECT post.id, post.nom, post.dateCreation, post.description, post.lien, post.titre_lien, post.asso" +
            "FROM post" +
            "WHERE DAY(NOW()) <= DAY(post.dateCreation)", nativeQuery = true)
    public abstract List<Post> rechercheFeed();*/

    @Query(value = "SELECT post.id,post.dateCreation, post.nom,  post.description, post.lien, post.titre_lien" +
            " FROM post INNER JOIN post_asso on post.id = post_asso.post_id " +
            "INNER JOIN association a on post_asso.association_id = a.id " +
            "WHERE a.nom = :nom", nativeQuery = true)
    public abstract List<Post> recherchePourAsso(String nom);
}
