package net.javaguides.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.mapper.PostMapperStruct;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private PostRepository postRepository;
  private PostMapperStruct postMapperStruct;

  public PostServiceImpl(PostRepository postRepository,
      PostMapperStruct postMapperStruct) {
    this.postRepository = postRepository;
    this.postMapperStruct = postMapperStruct;
  }

  @Override
  public List<PostDto> findAllPosts() {
    return postRepository.findAll().stream()
        .map(postMapperStruct::mapToPostDto).collect(Collectors.toList());
  }
}
