package com.example.f1standings.shared;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Controller {

    public <T> ResponseEntity<List<T>> resolveListResponse(List<T> result) {
        if(result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result);
    }
}
