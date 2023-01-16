package net.javaguides.springboot.repository;

import java.util.Optional;
import net.javaguides.springboot.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

  Optional<Post> findByUrl(String url);

}
