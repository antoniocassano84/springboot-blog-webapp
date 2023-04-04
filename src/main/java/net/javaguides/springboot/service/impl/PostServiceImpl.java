package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.entity.Post;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.mapper.PostMapper;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.repository.UserRepository;
import net.javaguides.springboot.service.PostService;
import net.javaguides.springboot.util.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static net.javaguides.springboot.util.SecurityUtils.*;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;
  private final UserRepository userRepository;

  @Override
  @Transactional
  public List<PostDto> findAllPosts() {
    return postRepository.findAllByOrderByIdAsc().stream().map(postMapper::mapToPostDto).toList();
  }

  @Override
  public void createPost(PostDto postDto) {
    String email = getCurrentUser().getUsername();
    Post post = postMapper.mapToPost(postDto);
    userRepository.findByEmail(email).ifPresent(post::setCreatedBy);
    postRepository.save(post);
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

  @Override
  @Transactional
  public List<PostDto> searchPosts(String query) {
    return postRepository.searchPosts(query).stream().map(postMapper::mapToPostDto).toList();
  }
}
