package org.zerock.w1.todo.service;

import com.sun.tools.javac.comp.Todo;
import org.zerock.w1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// enum 타입으로 클래스를 작성하는 경우 가장 큰 장점은 정해진 수 만큼만 객체를 생성할 수 있다는 점 - 객체를 하나만 생성해서 사용하는 패턴을 싱글톤 패턴(singleton pattern)이라고 한다
public enum TodoService {
    INSTANCE;

    public void register(TodoDTO todoDTO){
        // 원칙적으로 서비스 객체는 절대 출력하면 안되지만, 디버깅을 위한 용도로만 사용하도록 하자
        System.out.println("DEBUG......"+todoDTO);
    }

    public List<TodoDTO> getList(){

        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("Todo..."+i);
            dto.setDueDate(LocalDate.now());
            return dto;
        }).collect(Collectors.toList());
        return todoDTOS;
    }

}
