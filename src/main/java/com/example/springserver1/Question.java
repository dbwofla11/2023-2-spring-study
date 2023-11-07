package com.example.springserver1;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column( columnDefinition = "TEXT")
    private String QuestionUser;

    @Column( columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    // 여기서는 1대 다를 구현해야함
    @OneToMany(mappedBy = "question" , cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

//    CascadeType.REMOVE < 질문을 삭제하면 아래 답변도 다 삭제하기 위함 >

//    이때 질문을 삭제하면 그에 달린 답변들도 모두 함께 삭제하기
//    위해서 @OneToMany의 속성으로 cascade = CascadeType.REMOVE를 사용했다.
}
