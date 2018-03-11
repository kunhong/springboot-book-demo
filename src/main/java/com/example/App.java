package com.example;


import com.example.app.Argument;
import com.example.app.ArgumentResolver;
import com.example.app.Calculator;
import com.example.app.Frontend;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@EnableAutoConfiguration
@Import(AppConfig.class) // JavaConfig를 읽어들이기 위해 @Import로 @Configuration 이 붙은 클래스를 지정합니다.
public class App 
{
    public static void main( String[] args )
    {
        /*
        * SpringApplication.run() 으로 스프링 부트 애플리케이션을 실행합니다. 첫 번째 인자로는 @EnableAutoConfiguration을 붙인 클래스를 지정합니다.
        * 이 메서드의 반환 값은 DI 컨테이너의 본체인 ApplicationContext입니다. 이 예제에서는 close()로 닫을 수 있는 ConfigurableApplicationContext 타입으로 반환 값을 받습니다.
        * 그리고 자바7에서 도입한 try-with-resources 문 안에 변수를 선언하여 try 안쪽에서 처리가 끝나면 자동으로 close() 메소드가 호출되어 DI 컨테이너가 소멸되고 애플리케이션이 실행을 마치게 합니다.
        * */
        try(ConfigurableApplicationContext context = SpringApplication.run(App.class, args)) {
            /*
            Scanner scanner = new Scanner(System.in); // 표준 입력을 데이터로 받음
            System.out.println("Enter 2 numbers like 'a b' : ");

            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Calculator calculator = context.getBean(Calculator.class);
            int result = calculator.calc(a, b);
            System.out.println("result = " + result);
            scanner.close();


            // '계산하기' 와 '인자 받기' 부분을 외부로 분리하고 DI 컨테이너가 사용할 본체를 결정해준 덕분에 App 클래스를 좀 더 볌용으로 사용할 수 있게 되었습니다.
            // 그러나 이런 방식으로 프로그램이 커지면 context.getBean() 호출할 일이 많아지면서 관련 모듈이 늘어나고 코드가 지전분해질 것입니다.
            // 이러한 문제를 해결하는데 필요한 것이 DI 입니다.
            ArgumentResolver argumentResolver = context.getBean(ArgumentResolver.class);
            Argument argument = argumentResolver.resolve(System.in);
            Calculator calculator = context.getBean(Calculator.class);
            int result = calculator.calc(argument.getA(), argument.getB());
            System.out.println("result = " + result);
            */

            Frontend frontend = context.getBean(Frontend.class);
            frontend.run();
        }
    }
}
