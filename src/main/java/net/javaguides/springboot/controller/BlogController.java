package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class BlogController {

    public static final String BLOG_VIEW_POSTS = "blog/view_posts";
    private final PostService postService;

    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return BLOG_VIEW_POSTS;
    }
}
