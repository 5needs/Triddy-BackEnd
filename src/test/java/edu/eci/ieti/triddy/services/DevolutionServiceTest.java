package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Devolution;
import edu.eci.ieti.triddy.repository.DevolutionRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DevolutionServiceTest {
    @Autowired
    DevolutionRepository devolutionRepository;

    @Autowired
    @Qualifier("devolutionService")
    DevolutionService devolutionService;

    @AfterEach
    public void devolutionRestart(){
        devolutionRepository.deleteAll();
    }

    @Test
    public void addDevolution(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        try {
            devolutionService.addDevolution(devolution);
            assertNotEquals(null,devolutionRepository.findByIdDevolution("44411551151B"));

        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addDevolutionFailed(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        try {
            devolutionService.addDevolution(devolution);
        } catch (TriddyServiceException e) {
            assertNotEquals(null,devolutionRepository.findByIdDevolution("44411551151B"));
        }
    }

    @Test
    public void getDevolutionByIdProduct(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        Devolution devolution1 = new Devolution("4441151B","IP","test@gmail.com","testUser2@gmail.com","55555555","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        devolutionRepository.save(devolution1);
        assertEquals(true, devolutionService.getDevolutionByIdProduct("22").isEmpty());
    }

    @Test
    public void getDevolutionByIdClientAndStatus(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        Devolution devolution1 = new Devolution("4441151B","IP","test@gmail.com","testUser2@gmail.com","55555555","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        devolutionRepository.save(devolution1);
        assertEquals(2, devolutionService.getDevolutionByIdClientAndStatus("testUser2@gmail.com","IP").size());
    }

    @Test
    public void getDevolutionByIdUser(){
        Devolution devolution = new Devolution("44411551151B","IP","testUserOficial@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        Devolution devolution1 = new Devolution("4441151B","IP","test@gmail.com","testUser2@gmail.com","55555555","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        devolutionRepository.save(devolution1);
        assertEquals(1, devolutionService.getDevolutionByIdUser("testUserOficial@gmail.com").size());
    }

    @Test
    public void deleteDevolution(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        devolutionRepository.save(devolution);
        try {
            devolutionService.deleteDevolution(devolution);
            assertEquals(null,devolutionRepository.findByIdDevolution("44411551151B"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteDevolutionFailed(){
        Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");
        try {
            devolutionService.deleteDevolution(devolution);
        } catch (TriddyServiceException e) {
            assertEquals(null,devolutionRepository.findByIdDevolution("44411551151B"));
        }
    }







}
