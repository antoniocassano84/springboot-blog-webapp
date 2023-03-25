package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.CommentDto;

public interface CommentService {

    void createComment(String postUrl, CommentDto commentDto);
}
