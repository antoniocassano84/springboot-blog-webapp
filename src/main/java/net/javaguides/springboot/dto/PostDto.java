package net.javaguides.springboot.dto;

import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class PostDto {

  private Long id;
  @NotEmpty(message = "Post Title should not be empty")
  private String title;
  private String url;
  @NotEmpty(message = "Post Content should not be empty")
  private String content;
  @NotEmpty(message = "Post Short Description should not be empty")
  private String shortDescription;
  private LocalDateTime createdOn;
  private LocalDateTime updatedOn;

}
