package com.example.app;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data /*
       * @ Data 애너테이션을 붙이면 컴파일(*.class 파일 생성)할 때 각 필드의 setter/getter와
       * toString(), equals(), hashCode() 메서드가 생성되므로 소스코드가 간결해 진다.
       * 아래 코드에서는 필드에 final 제어자가 붙였기 때문에 setter 는 생성되지 않음
       */
@RequiredArgsConstructor
public class Argument {
    private final int a;
    private final int b;
}
