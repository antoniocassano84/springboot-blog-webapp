package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.dto.CommentDto;
import net.javaguides.springboot.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CommentController {

    public static final String POST_COMMENTS = "/{postUrl}/comments";

    CommentService commentService;

    @PostMapping(POST_COMMENTS)
    public String createComment(@ModelAttribute("comment")CommentDto commentDto,
                                @PathVariable("postUrl") String postUrl) {
        commentService.createComment(postUrl, commentDto);
        return "redirect:/post/" + postUrl;
    }
}
