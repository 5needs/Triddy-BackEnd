package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.ProductTag;

import java.util.List;

public interface FilterProductService {

    void addNewTag(String keyword) throws TriddyServiceException;

    List<ProductTag> getAllTags();

    ProductTag getTag(String keyword) throws TriddyServiceException;

    void addRelatedTag(String tagKeyword, String newRelatedTag) throws TriddyServiceException;

    void deleteTag(String keyword) throws TriddyServiceException;
}
