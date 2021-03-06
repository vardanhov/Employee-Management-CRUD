package com.practice.docs.service;



import com.practice.docs.dao.DocumentTypeDao;
import com.practice.docs.view.DocumentTypeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.practice.docs.model.DocumentType;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {
    private final Logger log = LoggerFactory.getLogger(getClass());

    private final DocumentTypeDao docTypeDao;


    @Autowired
    public DocumentTypeServiceImpl(DocumentTypeDao docTypeDao) {
        this.docTypeDao = docTypeDao;
    }


    /**
     * List of DocumentTypes
     *
     *
     */

    @Override
    @Transactional(readOnly = true)
    public List<DocumentTypeView> allDocumentType() {
        List<DocumentType> all = docTypeDao.all();

        Function<DocumentType, DocumentTypeView> mapDocumentType = p -> {
            DocumentTypeView view = new DocumentTypeView();
            view.code = p.getCode();
            view.name = p.getName();
            return view;
        };

        return all.stream()
                .map(mapDocumentType)
                .collect(Collectors.toList());
    }




}


