package com.chinasoft.service.impl;

import com.chinasoft.mapper.DocumentMapper;
import com.chinasoft.pojo.Document;
import com.chinasoft.service.DocumentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl {

    DocumentMapper mapper;

    public List<Document> selectAll() { return mapper.selectAll(); }

    public void addDocument(Document document) { }

    public void updateDocument(Document document) { }

    public List<Document> selectByParam(Document document) { return mapper.selectByParam(document); }

    public Document selectOne(int Oid) { return mapper.selectOne(Oid); }

    public void deleteDocument(List<Long> Oids) { }
}
