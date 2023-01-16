package net.javaguides.springboot.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data @Builder
public class PostDto {

  private Long id;
  private String title;
  private String url;
  private String content;
  private String shortDescription;
  private LocalDateTime createdOn;
  private LocalDateTime updatedOn;

}
