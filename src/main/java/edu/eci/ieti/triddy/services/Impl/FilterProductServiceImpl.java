package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.ProductTag;
import edu.eci.ieti.triddy.repository.TagRepository;
import edu.eci.ieti.triddy.services.FilterProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("filterProduct")
public class FilterProductServiceImpl implements FilterProductService {

    @Autowired
    TagRepository tagRepository;

    @Override
    public void addNewTag(String keyword) throws TriddyServiceException {
        ProductTag existTag = tagRepository.findByKeyword(keyword);
        if (existTag != null){
            throw new TriddyServiceException("Tag already Exists");
        }
        ProductTag tag = new ProductTag(keyword,new ArrayList<>());
        tagRepository.save(tag);
    }

    @Override
    public List<ProductTag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public ProductTag getTag(String keyword) throws TriddyServiceException{
        ProductTag existTag = tagRepository.findByKeyword(keyword);
        if (existTag == null){
            throw new TriddyServiceException("Tag Not Exists");
        }
        return existTag;
    }

    @Override
    public void addRelatedTag(String tagKeyword, String newRelatedTag) throws TriddyServiceException{
        ProductTag existTag = tagRepository.findByKeyword(tagKeyword);
        ProductTag relatedTag = tagRepository.findByKeyword(newRelatedTag);
        if (existTag != null){
            if (relatedTag != null){
                if (existTag.isRelated(newRelatedTag)){
                    throw new TriddyServiceException("Related Tag already Exists");
                }else {
                    existTag.addRelatedTag(newRelatedTag);
                    relatedTag.addRelatedTag(tagKeyword);
                    tagRepository.save(existTag);
                    tagRepository.save(relatedTag);
                }
            }else {
                throw new TriddyServiceException("Related Tag Not Exists");
            }
        }else {
            throw new TriddyServiceException("Tag Not Exists");
        }

    }

    @Override
    public void deleteTag(String keyword) throws TriddyServiceException{
        ProductTag existTag = tagRepository.findByKeyword(keyword);
        if(existTag == null){
            throw new TriddyServiceException("Tag Not Exists");
        }
        tagRepository.deleteByKeyword(keyword);
    }
}
