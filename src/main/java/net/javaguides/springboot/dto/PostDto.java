package net.javaguides.springboot.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PostDto {

  private Long id;
  private String title;
  private String url;
  private String content;
  private String shortDescription;
  private LocalDateTime createdOn;
  private LocalDateTime updatedOn;

}
