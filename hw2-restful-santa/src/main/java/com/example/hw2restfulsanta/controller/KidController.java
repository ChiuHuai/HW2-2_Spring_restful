package com.example.hw2restfulsanta.controller;

import com.example.hw2restfulsanta.model.Kid;
import com.example.hw2restfulsanta.service.KidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/kid")
public class KidController {

    @Autowired
    private KidService kidService;

    //http:localhost:8080/kid
    @GetMapping
    public List<Kid> getAllKids() {
        List<Kid> kids = this.kidService.getAllKids();
        if(kids.size() == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No kids in the list.");
        }
        return kids;
    }

    //http:localhost:8080/kid/{id}
    @GetMapping("/{id}")
    public Kid getKid(@PathVariable int id) {
        Kid kid = this.kidService.getKidById(id);
        if(kid == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return kid;
    }

    //http:localhost:8080/kid
    @PostMapping()
    public Kid createKid(@RequestBody Kid kid) {
        Kid newKid;
        try {
            newKid = this.kidService.createKid(kid);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage());
        }

        return newKid;
    }

    //http:localhost:8080/kid/{id}
    @PutMapping("/{id}")
    public Kid updateKid(@PathVariable int id, @RequestBody Kid kid) {
        Kid updateKid = this.kidService.updateKid(id, kid);
        if(updateKid == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }
        return updateKid;
    }

    //http:localhost:8080/kid/{id}
    @DeleteMapping("/{id}")
    public Kid deleteKid(@PathVariable int id) {
        Kid kid = this.kidService.deleteKid(id);
        if (kid == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        return kid;
    }
}
