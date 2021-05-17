package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class ProductTag {
    @Id
    private String id;
    private String keyword;
    private List<String> relatedTags;


    public ProductTag(String keyword, List<String> relatedTags) {
        this.keyword = keyword;
        this.relatedTags = relatedTags;
    }

    public ProductTag() {
    }

    public String getKeyword() {
        return keyword;
    }

    public List<String> getRelatedTags() {
        return relatedTags;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setRelatedTags(List<String> relatedTags) {
        this.relatedTags = relatedTags;
    }

    public Boolean isRelated(String newRelatedTag){
        if(relatedTags.contains(newRelatedTag)){
            return true;
        }else{
            return false;
        }
    }

    public void addRelatedTag(String newRelatedTag){
        relatedTags.add(newRelatedTag);
    }
}
