package com.example.product;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final List<Map<String, Object>> productsMock = new ArrayList<>(
            List.of(Map.of("id", 1, "name", "Iphone", "price", 1200)));

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String, Object> productBody) {
        productsMock.add(productBody);
        return productBody;
    }

    @GetMapping("/getAll")
    public List<Map<String, Object>> getAll() {
        return productsMock;
    }

    @GetMapping("/getById/{idParam}")
    public Map<String, Object> getById(@PathVariable int idParam) {
        return productsMock.stream()
                .filter(item -> (int) item.get("id") == idParam)
                .findFirst()
                .orElse(Map.of("error", "Produc not found"));
    }

    @PutMapping("/update/{idParam}")
    public Map<String, Object> update(@PathVariable int idParam,
            @RequestBody Map<String, Object> productBody) {
        for (int i = 0; i < productsMock.size(); i++) {
            Map<String, Object> existing = productsMock.get(i);
            if ((int) existing.get("id") == idParam) {
                productBody.put("id", idParam);
                productsMock.set(i, productBody);
                return Map.of("status", "updated", "product", productBody);
            }
        }
        return Map.of("error", "Product not found");
    }

    @DeleteMapping("/delete/{idParam}")
    public Map<String, Object> delete(@PathVariable int idParam) {
        Iterator<Map<String, Object>> iterator = productsMock.iterator();
        while (iterator.hasNext()) {
            Map<String, Object> item = iterator.next();
            if ((int) item.get("id") == idParam) {
                iterator.remove();
                return Map.of("status", "delete", "id", idParam);
            }
        }
        return Map.of("error", "Product not found");
    }

}
