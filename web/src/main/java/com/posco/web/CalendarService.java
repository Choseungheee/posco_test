package com.posco.web;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.posco.web.user.UserEntity;
import com.posco.web.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Map<String, Object>> getEventList() {
        Map<String, Object> event = new HashMap<String, Object>();
        List<Map<String, Object>> eventList = new ArrayList<Map<String, Object>>();
        event.put("start", LocalDate.now());
        event.put("title", "test");
        event.put("end",LocalDate.now());
        eventList.add(event);
        event = new HashMap<String, Object>();
        event.put("start", LocalDate.now().plusDays(3));
        event.put("title", "test2");
        event.put("end",LocalDate.now().plusDays(4));
        eventList.add(event);
        List<TodoEntity> todos = todoRepository.findAll();
        for(TodoEntity todo: todos){
            event = new HashMap<String, Object>();
            event.put("start", todo.getStartTime().format(DateTimeFormatter.ISO_DATE));
            event.put("title", todo.getTodo());
            event.put("end", todo.getEndTime().format(DateTimeFormatter.ISO_DATE));
            eventList.add(event);
        }
        return eventList;
    }

    public void addTodo(String todo, String id){
        System.out.println("add todo "+todo);
        TodoEntity todoEntity = TodoEntity.builder()
                .userId(id)
                .todo(todo)
                .startTime(LocalDateTime.now())
                .endTime(LocalDateTime.now().plusDays(3))
                .userEntity(userRepository.findById(id).orElseThrow())
                .build();
        todoRepository.save(todoEntity);
    }
}
