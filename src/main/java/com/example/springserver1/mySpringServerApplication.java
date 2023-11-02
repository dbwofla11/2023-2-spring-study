package com.example.springserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//    모든 프로그램에는 시작을 담당하는 파일이 있다.
//    스프링부트 애플리케이션에도 시작을 담당하는 파일이 있는데 그 파일이 바로 <프로젝트명> + Application.java 파일이다.
//    스프링부트 프로젝트를 생성할때"Sbb"라는 이름을 사용하면 다음과 같은 SbbApplication.java 파일이 자동으로 생성된다.

// <시작을 담당하는 클래스>
@SpringBootApplication
public class mySpringServerApplication {

    public static void main(String[] args){
        SpringApplication.run(mySpringServerApplication.class , args);
    }

}
