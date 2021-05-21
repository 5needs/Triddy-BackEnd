package edu.eci.ieti.triddy.services.Impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Points;
import edu.eci.ieti.triddy.repository.PointsRepository;
import edu.eci.ieti.triddy.services.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pointsService")
public class PointsServiceImpl implements PointsService {

    @Autowired
    PointsRepository pointsRepository;

    @Override
    public Points getPointsByIdClient(String idClient) throws TriddyServiceException {
        Points points = pointsRepository.findByIdClient(idClient);
        if (points != null){
            return points;
        }else{
            throw new TriddyServiceException("Points with Id Client: "+idClient+" is not registered");
        }
    }

    @Override
    public void improveLevelUserPoints(String idClient, String level, String discount, String category) {
        try {
            Points points = getPointsByIdClient(idClient);
            points.setLevel(level);
            points.setDiscount(discount);
            points.setCategory(category);
            addPoints(points);
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPoints(Points points) {
        pointsRepository.save(points);
    }

}