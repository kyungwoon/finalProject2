package com.clone.finalProject.controller;

import com.clone.finalProject.dto.PostResponseDto;
import com.clone.finalProject.dto.TagsResponseDto;
import com.clone.finalProject.service.TagsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TagsController {
    private final TagsService tagsService;

    public TagsController(TagsService tagsService) {
        this.tagsService = tagsService;
    }


    //태그 조회
    @GetMapping("/tag/search/{tag}")
    public List<PostResponseDto> searchTag(@PathVariable String tag) {
        System.out.println("tag : "  + tag);
        List<PostResponseDto> postResponseDtoList = tagsService.searchTag(tag);
        return postResponseDtoList;
    }



}
