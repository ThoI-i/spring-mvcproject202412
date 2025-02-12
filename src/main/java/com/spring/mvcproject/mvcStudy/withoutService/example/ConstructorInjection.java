package com.spring.mvcproject.mvcStudy.withoutService.example;

public class ConstructorInjection {
    public static void main(String[] args) {
        // Person 객체 생성
        Person person = new Person("엘리시아");


        // 메서드 호출
        person.sayHello();  // 출력: 안녕하세요, 저는 엘리시아입니다.

    }
}

// Person 클래스 정의
class Person {
    private String name;  // 전역 변수 선언

    // 생성자
    public Person(String name) {
        this.name = name;  // 매개변수 값을 전역 변수에 저장
    }

    // 인사 메서드
    public void sayHello() {
        System.out.println("안녕하세요, 저는 " + name + "입니다.");
    }
}
