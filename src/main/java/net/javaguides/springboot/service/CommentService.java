package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.CommentDto;

import java.util.List;

public interface CommentService {

    void createComment(String postUrl, CommentDto commentDto);

    List<CommentDto> findALlComments();

  void deleteComment(Long commentId);
}
