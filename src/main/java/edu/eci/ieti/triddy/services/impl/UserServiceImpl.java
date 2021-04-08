package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.model.University;
import edu.eci.ieti.triddy.repository.UniversityRepository;
import edu.eci.ieti.triddy.services.UniversityService;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class UserServiceImpl implements UniversityService {

    @Autowired
    UniversityRepository universityRepository;

    private University getUniversityById(String idUniversity) throws TriddyServiceException {
        University university = universityRepository.findByIdUniversity(idUniversity);
        if (university != null){
            return university;
        }else{
            throw new TriddyServiceException("University with Id: "+idUniversity+" is not registered");
        }
    }

    @Override
    public void addUniversity(University universityTarget, String idClient) {
        universityTarget.setDiscount(universityTarget.getIdUniversity());
        universityTarget.setStudents(idClient);
        universityRepository.save(universityTarget);
    }

    @Override
    public ArrayList<String> getStudentsByUniversity(String idUniversity) throws TriddyServiceException {
        ArrayList<String> students =  getUniversityById(idUniversity).getStudents();
        return students;
    }

    @Override
    public void updateStudentByUniversity(String idUniversity, String idClient) throws TriddyServiceException {
        University university = getUniversityById(idUniversity);
        university.getStudents().remove(idClient);
        universityRepository.save(university);
    }

    @Override
    public void deleteUniversityById(String idUniversity) throws TriddyServiceException {
        University university = getUniversityById(idUniversity);
        universityRepository.deleteByIdUniversity(university.getIdUniversity());
    }

}
