/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controlador;

import com.example.demo.Modelo.Tool;
import com.example.demo.Servicio.ToolService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author asesi
 */
@RestController
@RequestMapping("/api/Tool")
public class ToolController {
    @Autowired
    private ToolService toolService;
    
    @GetMapping("/all")
    public List<Tool> getAll(){
        return toolService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Tool> getTool(@PathVariable("id") int id){
        return toolService.getTool(id);
    } 
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool save (@RequestBody Tool tool){
        return toolService.save(tool);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Tool update(@RequestBody Tool tool){
        return toolService.save(tool);
    }

     @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int toolId){
        return toolService.deleteTool(toolId);
    }
}
