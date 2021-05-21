package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Points;

public interface PointsService {

    Points getPointsByIdClient(String idClient) throws TriddyServiceException;;

    void improveLevelUserPoints(String idClient, String level, String discount, String category);

    void addPoints(Points points);
}
