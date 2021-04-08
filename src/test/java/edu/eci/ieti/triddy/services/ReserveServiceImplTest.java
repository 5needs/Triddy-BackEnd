package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.controller.ReclaimController;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reclaim;
import edu.eci.ieti.triddy.repository.ReclaimRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ReserveServiceImplTest {

    @Autowired
    ReclaimService reserveService;

    @Autowired
    ReclaimRepository reserveRepository;

    @Autowired
    ReclaimController reserveController;

    @AfterEach
    void deletePayments(){
        reserveRepository.deleteAll();
    }

    @Test
    public void addReserve() {
        Reclaim reserve = new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
        reserveService.addReserve(reserve);
        Reclaim reserve2 = reserveRepository.findByIdReserve("123");
        assertNotNull(reserve2.getIdReserve());
    }

    @Test
    public void getReserveByIdClient() {
        try {
            Reclaim reserve = new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
            reserveService.addReserve(reserve);
            List<Reclaim> reserves = reserveService.getReserveByIdClient("12");
            assertTrue(reserves.size()!=0);
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reserves with Id Client:"));
        }
    }

    @Test
    public void getReserveByIdReserve() {
        try {
            Reclaim reserve = new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
            reserveService.addReserve(reserve);
            Reclaim reserve2 = reserveService.getReserveByIdReserve("123");
            assertEquals(reserve2.getIdReserve(),"123");
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reclaim with Id:"));
        }
    }

    @Test
    public void deleteReserveByIdReserve() {
        try {
            Reclaim reserve = new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
            reserveService.addReserve(reserve);
            reserveService.deleteReserveByIdReserve("123");
            Reclaim reserve2 = reserveService.getReserveByIdReserve("123");
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Reclaim with Id:"));
        }
    }

}
