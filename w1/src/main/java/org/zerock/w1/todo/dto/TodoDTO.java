package org.zerock.w1.todo.dto;

import java.time.LocalDate;
/*
3티어와 같이 계층을 분리하는 경우에는 반드시 계층이나 객체들 간 데이터 교환이 이루어 진다. 이 경우 대부분 한 개 이상의 데이터를 전달할 때가 많기 때문에 여러개의 데이터를 묶어서 하나의 객체로 전달하는 것을 DTO(Data Transfer Object)라고 한다. DTO는 여러 개의 데이터를 묶어 필요한 곳에 전달하거나 호출을 결과로 받는 방식으로 사용하기 때문에 특별한 규격이나 제약이 있는 것은 아니지만, 대부분은 Java Beans 형태로 구성하는 경우가 많다. Java Beans의 형식을 알아보자
1. 생성자가 없거나 반드시 파라미터가 없는 생성자 함수를 가지는 형태 = 선언만 하면 된다
2. 속성은 private로 작성
3. getter/setter 를 제공할 것

단순히 여러개의 데이터를 묶어 하나의 객체를 구성하는 용도로 사용하고 주로 서비스 객체 메소드들의 파라미터나 리턴 타입으로 사용한다.
서비스 객체는 간단히 말하면 '기능들의 묶음'인데, 프로그램이 구현해야하는 기능들의 실제 처리를 담당한다.
 */

public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

    public Long getTno() {
        return tno;
    }

    public void setTno(Long tno) {
        this.tno = tno;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public String toString() {
        return "TodoDTO {"+
                "tno=" + tno +
                ", title='" + title + '\''+
                ", dueDate=" + dueDate +
                ", finished=" + finished+
                '}';
    }
}
