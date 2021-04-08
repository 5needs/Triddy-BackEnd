package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import edu.eci.ieti.triddy.model.Devolution;
import edu.eci.ieti.triddy.repository.DevolutionRepository;
import edu.eci.ieti.triddy.services.DevolutionService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootTest
public class DevolutionControllersTest {

    @Autowired
    DevolutionControllers devolutionControllers;

    @Autowired
    DevolutionRepository devolutionRepository;

    @AfterEach
    public void devolutionRestart(){
        devolutionRepository.deleteAll();
    }

    @Test
    public void getDevolutionByIdProduct(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        ResponseEntity<List<Devolution>> responseEntity = devolutionControllers.getDevolutionByIdProduct("8558587556");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void getDevolutionByIdClientAndStatus(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        ResponseEntity<List<Devolution>> responseEntity = devolutionControllers.getDevolutionByIdClientAndStatus("testUser2@gmail.com","IP");
        assertEquals("44411551151B",responseEntity.getBody().get(0).getIdDevolution());
    }

    @Test
    public void getDevolutionByIdUser(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        ResponseEntity<List<Devolution>> responseEntity = devolutionControllers.getDevolutionByIdUser("testNotExistsUser@gmail.com");
        assertEquals(true,responseEntity.getBody().isEmpty());
    }

    @Test
    public void addDevolution(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        ResponseEntity<String> responseEntity = devolutionControllers.addDevolution(devolution);
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void addDevolutionFailed(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        ResponseEntity<String> responseEntity = devolutionControllers.addDevolution(devolution);
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void deleteDevolution(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        ResponseEntity<String> responseEntity = devolutionControllers.deleteDevolution(devolution);
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void deleteDevolutionFailed(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        ResponseEntity<String> responseEntity = devolutionControllers.deleteDevolution(devolution);
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }







}
