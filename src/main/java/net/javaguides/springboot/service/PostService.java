package net.javaguides.springboot.service;

import java.util.List;
import net.javaguides.springboot.dto.PostDto;

public interface PostService {

  List<PostDto> findAllPosts();

}
