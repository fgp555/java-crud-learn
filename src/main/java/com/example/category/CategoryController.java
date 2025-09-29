package com.example.category;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @GetMapping("/getOne")
    public Map<String, Object> getOne() {
        return Map.of(
                "id", "1", "name", "Mobile");
    }

    @GetMapping("/getAll")
    public List<Map<String, Object>> getAll() {
        return List.of(
                Map.of("id", "1", "name", "Mobiles"),
                Map.of("id", "2", "name", "Laptops"));
    }
}
