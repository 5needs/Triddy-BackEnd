package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.Calification;

public interface CalificationService {

    List<Calification> getProductCalifications(String product);

    List<Calification> getUserCalifications(String user);

    List<Calification> getCalificationsByUser (String qualifier);

    Double getProductStatus(String product);

    Double getProductCharacteristic(String product);

    Double getUserCalification(String user);

    Calification addCalification(Calification calification);
    
}
