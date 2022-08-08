package com.revature.SpringBootDemo.controllers;

import static com.revature.SpringBootDemo.utils.ClientMessageUtils.*;
import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.services.CandyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@CrossOrigin(origins = {"http://127.0.0.1:5500"})
@RestController
@RequestMapping("/app")
public class CandyController {

    @Autowired
    private CandyService candyService;

    @GetMapping(value = "/candy", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Candy getById(@RequestParam int id){
        return candyService.getCandyById(id);
    }

    @GetMapping("/candies")
    public @ResponseBody List<Candy> getAll(){
        return candyService.getAllCandies();
    }

    @PostMapping("/candy")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createCandy(@RequestBody Candy candy){
        return candyService.createCandy(candy) ? CREATION_SUCCESSFUL:CREATION_FAILED;
    }

    @PutMapping("/candy")
    public @ResponseBody ClientMessage updateCandy(@RequestBody Candy candy){
        return candyService.updateCandy(candy) > 0 ? UPDATE_SUCCESSFUL:UPDATE_FAILED;
    }

    @DeleteMapping("/candy")
    public @ResponseBody ClientMessage deleteCandy(@RequestBody Candy candy){
        return candyService.deleteCandy(candy) ? DELETION_SUCCESSFUL:DELETION_FAILED;
    }
}
