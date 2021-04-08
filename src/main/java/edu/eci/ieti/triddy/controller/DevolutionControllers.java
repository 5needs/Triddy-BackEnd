package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Devolution;
import edu.eci.ieti.triddy.services.DevolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devolution")
public class DevolutionControllers {

    @Autowired
    @Qualifier("devolutionService")
    DevolutionService devolutionService;


    @GetMapping("/product/{idProduct}")
    public ResponseEntity<List<Devolution>> getDevolutionByIdProduct(@PathVariable String idProduct){
        return new ResponseEntity<>(devolutionService.getDevolutionByIdProduct(idProduct), HttpStatus.ACCEPTED);
    }

    @GetMapping("/client/{idClient}/status/{status}")
    public ResponseEntity<List<Devolution>> getDevolutionByIdClientAndStatus(@PathVariable String idClient,@PathVariable String  status){
        return new ResponseEntity<>(devolutionService.getDevolutionByIdClientAndStatus(idClient,status), HttpStatus.ACCEPTED);

    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<List<Devolution>> getDevolutionByIdUser(@PathVariable String idUser){
        return new ResponseEntity<>(devolutionService.getDevolutionByIdUser(idUser), HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDevolution(@RequestBody Devolution devolution){
        try {
            devolutionService.addDevolution(devolution);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteDevolution(@RequestBody Devolution devolution){
        try {
            devolutionService.deleteDevolution(devolution);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
