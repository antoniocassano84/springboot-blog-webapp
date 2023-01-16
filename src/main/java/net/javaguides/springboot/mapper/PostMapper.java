package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.PostDto;
import net.javaguides.springboot.entity.Post;

public class PostMapper {

  private PostMapper() {
    throw new IllegalStateException("Utility class");
  }

  public static PostDto mapToPostDto(Post post) {
      return PostDto.builder()
          .id(post.getId())
          .url(post.getUrl())
          .title(post.getTitle())
          .content(post.getContent())
          .shortDescription(post.getShortDescription())
          .createdOn(post.getCreatedOn())
          .updatedOn(post.getUpdatedOn())
          .build();
  }

  public static Post mapToPost(PostDto postDto) {
      return Post.builder()
         .id(postDto.getId())
         .url(postDto.getUrl())
         .title(postDto.getTitle())
         .content(postDto.getContent())
         .shortDescription(postDto.getShortDescription())
         .createdOn(postDto.getCreatedOn())
         .updatedOn(postDto.getUpdatedOn())
         .build();
  }

}
