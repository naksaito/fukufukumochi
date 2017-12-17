package com.fukufuku.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class Repository {
    @Autowired
    RepositoryInterface repositoryInterface;

    @RequestMapping(method = RequestMethod.GET)
    public List<Entity> getMessages() {
        System.out.println(repositoryInterface.findAll());
        return repositoryInterface.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Entity postMessages(@RequestBody String message) {
        Entity entity = new Entity(message);
        System.out.println(message);
        return repositoryInterface.save(entity);
    }
}
