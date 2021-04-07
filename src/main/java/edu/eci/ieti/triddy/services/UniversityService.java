package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.University;

import java.util.ArrayList;

public interface UniversityService {

    void addUniversity(University universityTarget, String idClient);

    ArrayList<String> getStudentsByUniversity(String idUniversity) throws TriddyServiceException;

    void updateStudentByUniversity(String idUniversity, String idClient) throws TriddyServiceException;

    void deleteUniversityById(String idUniversity) throws TriddyServiceException;;
}
