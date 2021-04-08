package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.controller.ReclaimController;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reclaim;
import edu.eci.ieti.triddy.repository.ReclaimRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UniversityServiceImplTest {

    @Autowired
    ReclaimService reclaimService;

    @Autowired
    ReclaimRepository reclaimRepository;

    @Autowired
    ReclaimController reclaimController;

    @AfterEach
    void deleteReclaims(){
        reclaimRepository.deleteAll();
    }

    @Test
    public void addReclaim() {
        Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
        reclaimService.addReclaim(reclaim);
        Reclaim reclaim2 = reclaimRepository.findByIdReclaim("12");
        assertNotNull(reclaim2.getIdReclaim());
    }

    @Test
    public void getReclaimById() {
        try {
            Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
            reclaimService.addReclaim(reclaim);
            Reclaim reclaim2 = reclaimService.getReclaimById("12");
            assertTrue(reclaim2.getIdReclaim().contains("12"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reclaim with Id:"));
        }
    }

    @Test
    public void getReclaimByIdClient() {
        try {
            Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
            reclaimService.addReclaim(reclaim);
            Reclaim reclaim2 = reclaimService.getReclaimByIdClient("13");
            assertTrue(reclaim2.getIdClient().contains("13"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reclaim with Id:"));
        }
    }

    @Test
    public void getReclaimByIdOferent() {
        try {
            Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
            reclaimService.addReclaim(reclaim);
            Reclaim reclaim2 = reclaimService.getReclaimByIdOferent("14");
            assertTrue(reclaim2.getIdOferent().contains("14"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reclaim with Id:"));
        }
    }

    @Test
    public void deleteReclaimByIidReclaim() {
        try {
            Reclaim reclaim = new Reclaim("12","13","14","robo","muy malo todo");
            reclaimService.addReclaim(reclaim);
            reclaimService.deleteReclaimByIidReclaim("12");
            Reclaim reclaim2 = reclaimService.getReclaimById("12");
        }catch (TriddyServiceException e) {
            System.out.println(e.getMessage());
            assertTrue(e.getMessage().contains("Reclaim with Id : 12 is not registered"));
        }
    }


}
