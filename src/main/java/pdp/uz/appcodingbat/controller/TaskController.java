package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Example;
import pdp.uz.appcodingbat.entity.Task;
import pdp.uz.appcodingbat.payload.ExampleDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.payload.TaskDto;
import pdp.uz.appcodingbat.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping
    public HttpEntity<Result> addTask(@RequestBody TaskDto taskDto) {
        Result result = taskService.addTask(taskDto);
        return ResponseEntity.ok(result);
    }

    //Delete
    @DeleteMapping(value = "/api/task/{taskId}")
    public HttpEntity<Result> deleteTask(@PathVariable Integer taskId) {
        Result result = taskService.deleteTask(taskId);
        return ResponseEntity.ok(result);
    }

    //Update
    @PutMapping (value = "/api/task/{taskId}")
    public HttpEntity<Result> editTask(@PathVariable Integer taskId, @RequestBody TaskDto taskDto) {
        Result result = taskService.editTask(taskId, taskDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public HttpEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.getTasks();
        return ResponseEntity.ok(tasks);
    }
}
