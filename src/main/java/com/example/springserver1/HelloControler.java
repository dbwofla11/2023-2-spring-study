package com.example.springserver1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

// 실험 렌더링 컨트롤러
@Controller
public class HelloControler {

    @Autowired
    private QuestionRepo questionRepo;

    @GetMapping("/hello")
    @ResponseBody
    public void hello(){
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
}
