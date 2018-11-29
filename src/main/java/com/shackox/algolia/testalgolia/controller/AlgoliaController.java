package com.shackox.algolia.testalgolia.controller;

import com.shackox.algolia.testalgolia.dto.TodoDto;
import com.shackox.algolia.testalgolia.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController("/algolia")
public class AlgoliaController {
    @Autowired
    private IndexService indexService;

    @PostMapping("/create-todo")
    @ResponseBody
    public ResponseEntity createTodo(@RequestBody TodoDto todoDto, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>();
        result.put("todo", todoDto);
        result.put("status", "Ok");
        indexService.indexTodo(todoDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
