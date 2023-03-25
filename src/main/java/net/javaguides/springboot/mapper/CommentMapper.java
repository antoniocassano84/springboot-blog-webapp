package net.javaguides.springboot.mapper;

import net.javaguides.springboot.dto.CommentDto;
import net.javaguides.springboot.entity.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto mapToCommentDto(Comment comment);
    Comment mapToComment(CommentDto commentDto);

}
