package net.javaguides.springboot.service;

import java.util.List;
import net.javaguides.springboot.dto.PostDto;

public interface PostService {

  List<PostDto> findAllPosts();
  void create_post(PostDto postDto);

  PostDto findPostById(Long postId);

  PostDto findPostByUrl(String postUrl);

  void update_post(PostDto postDto);

  void deletePost(Long postId);

}
