package com.example.CRUD.Controller;

import com.example.CRUD.Model.CRUDEntity;
import com.example.CRUD.Service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud")
public class Controller {


        @Autowired
        private CRUDService service;

        @PostMapping
        public ResponseEntity<CRUDEntity> create(@RequestBody CRUDEntity entity) {
            return ResponseEntity.ok(service.create(entity));
        }

        @GetMapping
        public ResponseEntity<List<CRUDEntity>> getAll() {
            return ResponseEntity.ok(service.getAll());
        }

        @GetMapping("/{id}")
        public ResponseEntity<CRUDEntity> getById(@PathVariable Long id) {
            return service.getById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @PutMapping("/{id}")
        public ResponseEntity<CRUDEntity> update(@PathVariable Long id, @RequestBody CRUDEntity entity) {
            return ResponseEntity.ok(service.update(id, entity));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> delete(@PathVariable Long id) {
            service.delete(id);
            return ResponseEntity.ok("Deleted successfully");
        }
    }
