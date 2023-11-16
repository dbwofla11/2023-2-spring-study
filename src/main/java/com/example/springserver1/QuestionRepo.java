package com.example.springserver1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question , Integer>
{
    Question findBySubject(String subject); // 이런것 들이 미리 컨트롤러 안에 들어가 있어야 함
//    Question findBySubjectAndContent(String subject, String content);

}
