package cn.wengzi.controller;

import cn.wengzi.entity.Student;
import cn.wengzi.service.FeignProviderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wengzi
 * @date 2019/10/27 afternoon 16:22
 */
@RestController
@RequestMapping("/hystrix")
public class HystrixHandler {

    @Autowired
    private FeignProviderClient feignProviderClient;

    @GetMapping("/findAll")
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = new ArrayList<>(feignProviderClient.findAll());
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(feignProviderClient.findById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public void save(@RequestBody Student student) {
        feignProviderClient.save(student);
    }

    @PutMapping("/upd")
    public void upd(@RequestBody Student student) {
        feignProviderClient.upd(student);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        feignProviderClient.deleteById(id);
    }

    @GetMapping("/getPort")
    public String getPort() {
        return feignProviderClient.getPort();
    }

}
