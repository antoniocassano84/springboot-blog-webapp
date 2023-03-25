package net.javaguides.springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CommentDto {
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty @Email
    private String email;
    @NotEmpty
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
