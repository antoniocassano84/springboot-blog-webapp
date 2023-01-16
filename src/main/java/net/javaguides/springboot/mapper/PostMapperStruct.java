package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapperStruct {

  PostDto mapToPostDto(Post post);
  Post mapToPost(PostDto postDto);

}
