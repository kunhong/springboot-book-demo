package com.example;

// Calculator 인터페이스에 어떤 실제 기능 Bean을 제공할지는 DI 컨테이너가 관리하도록 구현 합니다.
// DI 컨테이너가 Bean을 관리할 수 있도록 Bean 정의 파일을 만듭니다.
// XML 로 정의하는 방법과 자바 클래스(JavaConfig)로 정의 하는 방법이 있습니다. 여기서는 자바 클래스로 정의하는 방법을 살펴 봅시다.

import com.example.app.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // JavaConfig용 클래스임을 컴파일러에게 알림
public class AppConfig {

    @Bean /*
            DI 컨테이너가 관리할 Bean을 생성하는 메서드에는 @Bean 애너테이션을 붙입니다.
            기본으로 메서드 이름이 Bean 이름이 됩니다.
            또한 기본값으로 이 메서드가 생성한 인스턴스가 싱글톤이 되며, DI 컨테이너별로 인스턴스 한 개가 생성됩니다.
            */
    Calculator calculator() {
        return new AddCalculator();
    }

    @Bean
    ArgumentResolver argumentResolver() {
        return new ScannerArgumentResolver();
    }

    @Bean
    Frontend frontend() {
        return new Frontend();
    }
}
