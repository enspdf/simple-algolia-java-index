package com.shackox.algolia.testalgolia.service;

import com.algolia.search.AsyncAPIClient;
import com.algolia.search.AsyncHttpAPIClientBuilder;
import com.algolia.search.AsyncIndex;
import com.shackox.algolia.testalgolia.dto.TodoDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Value("${algolia.index-name}")
    String indexName;

    @Value("${algolia.application-id}")
    String applicationId;

    @Value("${algolia.admin-api-key}")
    String apiKey;

    public void indexTodo(TodoDto todoDto) {
        AsyncAPIClient client = new AsyncHttpAPIClientBuilder(applicationId, apiKey).build();
        AsyncIndex<TodoDto> indexTodo = client.initIndex(indexName, TodoDto.class);
        indexTodo.addObject(todoDto);
    }
}
