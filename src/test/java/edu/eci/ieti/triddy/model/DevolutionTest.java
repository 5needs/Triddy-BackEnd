package edu.eci.ieti.triddy.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DevolutionTest {
    Devolution devolution = new Devolution("44411551151B","IP","test@gmail.com","testUser2@gmail.com","8558587556","2021-06-24-11:31","...");

    @Test
    void getIdDevolution() {
        assertEquals("44411551151B", devolution.getIdDevolution() );
    }

    @Test
    void setIdDevolution() {
        devolution.setIdDevolution("44411551151A");
        assertNotEquals("44411551151B", devolution.getIdDevolution());
    }

    @Test
    void getStateDelivery() {
        assertEquals("IP",devolution.getStateDelivery());
    }

    @Test
    void setStateDelivery() {
        devolution.setStateDelivery("IPK");
        assertNotEquals("IP",devolution.getStateDelivery());
    }

    @Test
    void getIdUser() {
        assertEquals("test@gmail.com",devolution.getIdUser());
    }

    @Test
    void setIdUser() {
        devolution.setIdUser("testLO@gmail.com");
        assertNotEquals("test@gmail.com",devolution.getIdUser());
    }

    @Test
    void getIdClient() {
        assertEquals("testUser2@gmail.com",devolution.getIdClient());
    }

    @Test
    void setIdClient() {
        devolution.setIdClient("testUser45@gmail.com");
        assertNotEquals("testUser2@gmail.com",devolution.getIdClient());
    }

    @Test
    void getIdProduct() {
        assertEquals("8558587556",devolution.getIdProduct());
    }

    @Test
    void setIdProduct() {
        devolution.setIdProduct("55555");
        assertNotEquals("8558587556",devolution.getIdProduct());
    }

    @Test
    void getDateTime() {
        assertEquals("2021-06-24-11:31",devolution.getDateTime());
    }

    @Test
    void setDateTime() {
        devolution.setDateTime("2022-06-24-10:31");
        assertNotEquals("2021-06-24-11:31",devolution.getDateTime());
    }

    @Test
    void getComments() {
        assertEquals("...",devolution.getComments());
    }

    @Test
    void setComments() {
        devolution.setComments("Funcional");
        assertNotEquals("...",devolution.getComments());
    }
}
