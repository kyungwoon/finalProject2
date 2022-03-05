package com.clone.finalProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Long uid;
    private String postTitle;
    private String postComment;
    private String postImg;
    private List<String> tags;

}
