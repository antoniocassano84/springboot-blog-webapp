package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.mapper.PostMapper;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;
  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<PostDto> findAllPosts() {
    return postRepository.findAll().stream()
        .map(PostMapper::mapToPostDto).collect(Collectors.toList());
  }
}
