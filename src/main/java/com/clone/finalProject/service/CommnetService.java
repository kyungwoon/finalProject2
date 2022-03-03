package com.clone.finalProject.service;

import com.clone.finalProject.domain.Answer;
import com.clone.finalProject.domain.Comment;
import com.clone.finalProject.domain.User;
import com.clone.finalProject.dto.CommnetResponseDto;
import com.clone.finalProject.repository.AnswerRepository;
import com.clone.finalProject.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommnetService {

    private final AnswerRepository answerRepository;
    private final CommentRepository commentRepository;


    //commnet 생성
    public Long commentCreate(CommnetResponseDto commnetResponseDto, User user) {
        Answer answer = answerRepository.findByAnswerId(commnetResponseDto.getAnswerId()).orElseThrow(
                ()-> new NullPointerException("comment가 존재하지 않습니다.")
        );

        Comment comment = new Comment(commnetResponseDto,answer);
        commentRepository.save(comment);
        System.out.println("commnet 생성 완료");

        return comment.getCommentId();

    }

    //commnet 삭제
    public void commentDelete(Long uid, Long commentId) {
        Comment comment = commentRepository.findByCommentId(commentId).orElseThrow(
                ()-> new NullPointerException("comment가 존재하지 않습니다.")
        );

        if(comment.getAnswer().getPost().getUser().getUid()==uid){

            commentRepository.deleteById(commentId);
            System.out.println("comment 삭제 완료 commentId : " + commentId);
        }


    }
    //commnet 수정
    @Transactional
    public void commentEdit(Long commentId, CommnetResponseDto commnetResponseDto, Long uid) {
        Comment comment = commentRepository.findByCommentId(commentId).orElseThrow(
                ()-> new NullPointerException("comment가 존재하지 않습니다.")
        );
        if(comment.getAnswer().getPost().getUser().getUid()==uid){

            comment.update(commnetResponseDto);
            System.out.println("comment 수정 완료 commentId : " + commentId);
        }


    }
}