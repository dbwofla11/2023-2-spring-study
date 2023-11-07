package com.example.springserver1;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class mySpringServerApplicationTests {

    @Autowired
    private QuestionRepo questionRepo;

    @Test
    void contextLoads() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가여");
        q1.setContent("sbb에 대해 알고 싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepo.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepo.save(q2);  // 두번째 질문

    }

    @Test
    void testJpa() {
        List<Question> all = this.questionRepo.findAll();
        assertEquals(2, all.size());

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

}
