package net.javaguides.springboot.service.impl;

import java.util.List;
import net.javaguides.springboot.dto.PostDto;
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
    return postRepository.findAll().stream()
        .map(postMapper::mapToPostDto).toList();
  }

  @Override
  public void create_post(PostDto postDto) {
    postRepository.save(postMapper.mapToPost(postDto));
  }
}
