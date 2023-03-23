package net.javaguides.springboot.service.impl;

import java.util.List;
import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.mapper.PostMapper;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;

  @Override
  public List<PostDto> findAllPosts() {
    return postRepository.findAllByOrderByIdAsc().stream().map(postMapper::mapToPostDto).toList();
  }

  @Override
  public void createPost(PostDto postDto) {
    postRepository.save(postMapper.mapToPost(postDto));
  }

  @Override
  public PostDto findPostById(Long postId) {
    return postRepository.findById(postId).map(postMapper::mapToPostDto).orElse(null);
  }

  @Override
  @Transactional
  public PostDto findPostByUrl(String postUrl) {
    return postRepository.findByUrl(postUrl).map(postMapper::mapToPostDto).orElse(null);
  }

  @Override
  public void updatePost(PostDto postDto) {
    postRepository.save(postMapper.mapToPost(postDto));
  }

  @Override
  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
