package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;

// DI 컨테이너가 클래스에 Bean을 주입(Injection) 하도록 구현해 봅시다.
// 먼저 App 클래스에서 구현할 처리를 정리할 Fontend 클래스를 만들고 이미 작성한 Calculator 와 ArgumentResolver 를 Frontend 클래스에 주입합니다.
public class Frontend {
    @Autowired // DI 컨테이너가 주입해야 할 필드를 의미, DI 컨테이너는 @Autowired 애너테이션을 붙인 필드를 포함한 클래스를 관리
               // DI 컨테이너는 관리하고 있는 객체 중에서 @Autowired 애너테이션을 붙은 필드에 맡는 객체를 자동으로 찾아내어 주입
               // 이와 같은 구조를 오토 와이어링 이라고 부름
    ArgumentResolver argumentResolver;

    @Autowired
    Calculator calculator;

    public  void run() {
        System.out.print("Enter 2 number like 'a b' : ");
        Argument argument = argumentResolver.resolve(System.in);
        int result = calculator.calc(argument.getA(), argument.getB());
        System.out.println("result = " + result);
    }
}
