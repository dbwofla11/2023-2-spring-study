package com.example.springserver1;

import java.time.LocalDateTime;

// 이렇게 하면 다 가져올 수 있음
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(columnDefinition = "TEXT")
    private String User;

    private LocalDateTime createDate;

    // 일대 다 속성이기 때문에 Many to One 이라는 어노티네이션을 쓰는거
    // ( 질문 하나에 답변이 여러개니까 )
    // 이리하면 -> (실제 데이터베이스에서는 ForeignKey 관계가 생성된다.)
    // 여기서는 다 대 1
    @ManyToOne
    private Question question;
}
//
//Id, content, createDate 속성은 질문 엔티티와 동일하므로 설명은 생략한다.
//
//        question 속성은 답변 엔티티에서 질문 엔티티를 참조하기 위해 추가했다.
//        예를 들어 답변 객체(예:answer)를 통해 질문 객체의 제목을 알고 싶다면 answer.getQuestion().getSubject()처럼 접근할 수 있다.
//        하지만 이렇게 속성만 추가하면 안되고 질문 엔티티와 연결된 속성이라는 것을 명시적으로 표시해야 한다.
