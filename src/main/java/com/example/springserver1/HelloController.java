package com.example.springserver1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

// 실험 렌더링 컨트롤러
@Controller
public class HelloController {

    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/hello")
    @ResponseBody // req -> res
    public void hello(){
        List<Question> all = this.questionRepo.findAll(); // select *
        Question q_all = all.get(0);

        System.out.println("@@@ doTest로 이동!");
        Question q_bySubject = this.questionRepo.findBySubject("sbb가 무엇인가요?"); // select 이런식으로 CRUD를 할 수 있음
        System.out.println(q_all);

        Optional<Question> op = this.questionRepo.findById(1);
        if (op.isPresent()){

            Question q_byId = op.get(); // select를 한 다음에 DB에서 해당 객체 가지고 오기
            assertEquals("sbb가 무엇인가요?", q_byId.getSubject()); // 오류 검사

            q_byId.setSubject("수정된 제목");  // 데이터 수정하기
            this.questionRepo.save(q_byId); // 수정한 데이터 DB에 저장

            Optional<Question> oq2 = this.questionRepo.findById(2);
            // delete where 문 구현을 먼저 데이터 객체를 가지고 온 다음에
            // 그 활당된 객체에 수정을 하든 삭제를 하든 작업을 함 만약 수정을 했다면 저장을 다시 DB에 해줘야 함
            Question q2 = oq2.get();
            this.questionRepo.delete(q2); // 삭제는 리포에 바로 불러오기

            // 질문 게시판의 첫번째 글은 따로 참조를 하지 않고 바로 글쓰기가 가능함
            // 그렇기 때문에 어느 객체를 가져와서 그 객체랑 비교를 안해도 됨
        }
    }

    @Autowired
    private AnswerRepo answerRepo;

    @GetMapping("/answer")
    @ResponseBody
    public void answer(){
        // 답변 데이터 생성 후 저장하기
        Optional<Question> oq = this.questionRepo.findById(2);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
        a.setCreateDate(LocalDateTime.now());
        this.answerRepo.save(a);
    }

}
