package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class ProductTagTest {

    ProductTag productTag;

    @Test
    public void getKeyword(){
        productTag = new ProductTag("Test1Tag",new ArrayList<>());
        assertEquals("Test1Tag",productTag.getKeyword());
    }

    @Test
    public void getRelatedTags(){
        productTag = new ProductTag("Test1Tag",new ArrayList<>());
        assertNotEquals(null,productTag.getRelatedTags());
    }

    @Test
    public void isRelated(){
        productTag = new ProductTag("Test1Tag",new ArrayList<>());
        assertEquals(false,productTag.isRelated("Test2Tag"));
    }

    @Test
    public void addRelatedTag(){
        productTag = new ProductTag("Test1Tag",new ArrayList<>());
        productTag.addRelatedTag("Test2Tag");
        assertEquals(true,productTag.isRelated("Test2Tag"));
    }

}
