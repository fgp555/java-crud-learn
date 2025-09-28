package com.example.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ProductController {

    @GetMapping("/product")
    public Map<String, Object> product() {
        // esto es lo más parecido a { name: "iphone" } en JS
        return Map.of(
                "name", "iPhone",
                "price", 1200);
    }
}
