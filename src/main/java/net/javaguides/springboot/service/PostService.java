package net.javaguides.springboot.service;

import java.util.List;
import net.javaguides.springboot.dto.PostDto;

public interface PostService {

  List<PostDto> findAllPosts();

  void createPost(PostDto postDto);

  PostDto findPostById(Long postId);

  void updatePost(PostDto postDto);

  PostDto findPostByUrl(String postUrl);

  void deletePost(Long postId);

}
