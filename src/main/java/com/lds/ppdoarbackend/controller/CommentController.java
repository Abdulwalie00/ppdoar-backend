// src/main/java/com/lds/ppdoarbackend/controller/CommentController.java

package com.lds.ppdoarbackend.controller;

import com.lds.ppdoarbackend.dto.CommentDto;
import com.lds.ppdoarbackend.model.Comment;
import com.lds.ppdoarbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments(@PathVariable String projectId, @AuthenticationPrincipal UserDetails userDetails) {
        return commentService.getCommentsForProject(projectId, userDetails);
    }

    @PostMapping
    public Comment createComment(@PathVariable String projectId, @RequestBody CommentDto commentDto, @AuthenticationPrincipal UserDetails userDetails) {
        // --- ADD THIS LINE FOR DEBUGGING ---
        System.out.println("Received comment content: '" + commentDto.getContent() + "'");

        commentDto.setProjectId(projectId);
        return commentService.createComment(commentDto, userDetails);
    }
}