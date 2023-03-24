package net.javaguides.springboot.controller;

import lombok.AllArgsConstructor;
import net.javaguides.springboot.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class BlogController {

    public static final String BLOG_VIEW_POSTS = "blog/view_posts";
    public static final String POST_URL = "/post/{postUrl}";
    public static final String BLOG_POST = "blog/blog_post";

    private final PostService postService;

    @GetMapping("/")
    public String viewBlogPosts(Model model) {
        model.addAttribute("posts", postService.findAllPosts());
        return BLOG_VIEW_POSTS;
    }

    @GetMapping(POST_URL)
    public String showPost(@PathVariable("postUrl") String postUrl, Model model) {
        model.addAttribute("post", postService.findPostByUrl(postUrl));
        return BLOG_POST;
    }
}
