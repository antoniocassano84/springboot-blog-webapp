package net.javaguides.springboot.repository;

import java.util.List;
import java.util.Optional;
import net.javaguides.springboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findByUrl(String url);

  @Transactional
  List<Post> findAllByOrderByIdAsc();
  @Query("SELECT p FROM Post p WHERE "
      + "p.title LIKE CONCAT('%', :query, '%') OR "
      + "p.shortDescription LIKE CONCAT('%', :query, '%')")
  List<Post> searchPosts(String query);

}
