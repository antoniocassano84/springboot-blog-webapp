package net.javaguides.springboot.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.CommentDto;
import net.javaguides.springboot.entity.Comment;
import net.javaguides.springboot.entity.Post;
import net.javaguides.springboot.mapper.CommentMapper;
import net.javaguides.springboot.repository.CommentRepository;
import net.javaguides.springboot.repository.PostRepository;
import net.javaguides.springboot.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    CommentRepository commentRepository;
    CommentMapper commentMapper;
    PostRepository postRepository;
    @Override
    @Transactional
    public void createComment(String postUrl, CommentDto commentDto) {
        Comment comment = commentMapper.mapToComment(commentDto);
        Optional<Post> optPost = postRepository.findByUrl(postUrl);
        if(optPost.isPresent()) {
            comment.setPost(optPost.get());
            commentRepository.save(comment);
        }
    }

    @Override
    public List<CommentDto> findALlComments() {
        return commentRepository.findAll().stream()
                .map(commentMapper::mapToCommentDto).toList();
    }
}
