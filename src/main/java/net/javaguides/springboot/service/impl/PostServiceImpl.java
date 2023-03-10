package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.Optional;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.entity.Post;
import net.javaguides.springboot.mapper.PostMapper;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final PostMapper postMapper;
  public PostServiceImpl(PostRepository postRepository,
                         PostMapper postMapper) {
    this.postRepository = postRepository;
    this.postMapper = postMapper;
  }

  @Override
  public List<PostDto> findAllPosts() {
    return postRepository.findAllByOrderByIdAsc().stream().map(postMapper::mapToPostDto).toList();
  }

  @Override
  public void create_post(PostDto postDto) {
    postRepository.save(postMapper.mapToPost(postDto));
  }

  @Override
  public PostDto findPostById(Long postId) {
    return postRepository.findById(postId).map(postMapper::mapToPostDto).orElse(null);
  }

  @Override
  public void update_post(PostDto postDto) {
    postRepository.save(postMapper.mapToPost(postDto));
  }

  @Override
  public void deletePost(Long postId) {
    postRepository.deleteById(postId);
  }
}
