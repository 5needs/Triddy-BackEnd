package edu.eci.ieti.triddy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.Calification;
import edu.eci.ieti.triddy.repository.CalificationRepository;
import edu.eci.ieti.triddy.services.CalificationService;

@Service
public class CalificationServiceImpl implements CalificationService {

    @Autowired
    CalificationRepository calificationRepository;


    public List<Calification> getProductCalifications(String product){
        return calificationRepository.findByProduct(product);
    }

    public List<Calification> getUserCalifications(String user){
        return calificationRepository.findByUser(user);
    }

    public List<Calification> getCalificationsByUser (String qualifier){
        return calificationRepository.findByQualifier(qualifier);
    }

    public Double getProductStatus(String product){
        Double res = 2.5;
        List<Calification> califications = calificationRepository.findByProduct(product);
        if (!califications.isEmpty()){
            Double sum = 0.0;
            for (int i = 0; i < califications.size(); i++){
                sum+= califications.get(i).getProducttatus();
            }
            res = sum / califications.size();
        }
        return res;
    }

    public Double getProductCharacteristic(String product){
        Double res = 2.5;
        List<Calification> califications = calificationRepository.findByProduct(product);
        if (!califications.isEmpty()){
            Double sum = 0.0;
            for (int i = 0; i < califications.size(); i++){
                sum+= califications.get(i).getProductCharacteristics();
            }
            res = sum / califications.size();
        }
        return res;
    }

    public Double getUserCalification(String user){
        Double res = 2.5;
        List<Calification> califications = calificationRepository.findByUser(user);
        if (!califications.isEmpty()){
            Double sum = 0.0;
            for (int i = 0; i < califications.size(); i++){
                sum+= califications.get(i).getUserCalification();
            }
            res = sum / califications.size();
        }
        return res;
    }

    public Calification addCalification(Calification calification){
        return calificationRepository.save(calification);
    }
    
}
