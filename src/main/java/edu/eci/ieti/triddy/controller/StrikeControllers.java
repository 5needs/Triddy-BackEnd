package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.UserStrike;
import edu.eci.ieti.triddy.services.StrikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/strikes")
public class StrikeControllers {

    @Autowired
    @Qualifier("strikeService")
    StrikeService strikeService;

    @GetMapping("/active/{active}")
    public ResponseEntity<List<UserStrike>> getStrikeByActive(@PathVariable Boolean active){
        return new ResponseEntity<>(strikeService.getStrikeByActive(active),HttpStatus.ACCEPTED);
    }

    @GetMapping("/User/{idUser}")
    public ResponseEntity<UserStrike> getUserStrike(@PathVariable String idUser){
        try {
            return new ResponseEntity<>(strikeService.getUserStrike(idUser),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/User/{idUser}")
    public ResponseEntity<String> addUserStrike(@PathVariable String idUser){
        try {
            strikeService.addUserStrike(idUser);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> addStrikeToUser(@RequestBody UserStrike userStrike){
        try {
            strikeService.addStrikeToUser(userStrike);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/User/{idUser}")
    public ResponseEntity<String> changeActiveStrike(@PathVariable String idUser){
        try {
            strikeService.changeActiveStrike(idUser);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/User/{idUser}/strike/{position}")
    public ResponseEntity<String> removeStrikeToUser(@PathVariable String idUser,@PathVariable int position){
        try {
            strikeService.removeStrikeToUser(idUser,position);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
