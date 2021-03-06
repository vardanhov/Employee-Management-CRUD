package com.practice.docs.dao;

import com.practice.docs.model.DocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public  class DocumentTypeDaoImpl implements DocumentTypeDao {
    private final EntityManager em;

    @Autowired
    public DocumentTypeDaoImpl(EntityManager em) {
        this.em = em;
    }
    /**
     * List of DocumentTypes
     *
     *
     */
    @Override
    public List<DocumentType> all() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = criteriaBuilder.createQuery(DocumentType.class);
        Root<DocumentType> docTypeRoot = criteria.from(DocumentType.class);
        criteria.select(docTypeRoot);
        List<DocumentType> docTypeList = em.createQuery(criteria).getResultList();
        return docTypeList;
    }


    /**
     * Find DocumtType by name
     *
     *
     */

    @Override
    public DocumentType getDocumentTypeByName(String name) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<DocumentType> criteria = builder.createQuery(DocumentType.class);
        Root<DocumentType> doc = criteria.from(DocumentType.class);
        criteria.where(builder.equal(doc.get("name"), name));
        TypedQuery<DocumentType> query = em.createQuery(criteria);
        return query.getSingleResult();


    }


}
