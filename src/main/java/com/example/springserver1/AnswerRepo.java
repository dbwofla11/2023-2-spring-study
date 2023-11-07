package com.example.springserver1;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepo extends JpaRepository<Answer , Integer>
{

}
