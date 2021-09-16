package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/ctegory")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public HttpEntity<List<Category>> getCategorys() {
        List<Category> categories = categoryService.getCategorys();
        return ResponseEntity.ok(categories);
    }

    //Delete
    @DeleteMapping(value = "/api/category/{categoryId}")
    public HttpEntity<Result> deleteCategory(@PathVariable Integer categoryId) {
        Result result = categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public HttpEntity<Result> addCategory(@RequestBody Category category){
        Result result = categoryService.addCategory(category);
        return ResponseEntity.ok(result);
    }

    //Update
    @PutMapping (value = "/api/category/{categoryId}")
    public HttpEntity<Result> editCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
        Result result = categoryService.editCategory(categoryId,category);
        return ResponseEntity.ok(result);
    }

}
