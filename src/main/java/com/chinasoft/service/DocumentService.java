package com.chinasoft.service;

import com.chinasoft.pojo.Document;

import java.util.List;

public interface DocumentService {

    List<Document> selectAll();

    void addDocument(Document document);

    void updateDocument(Document document);

    List<Document> selectByParam(Document document);

    Document selectOne(int Oid);

    void deleteDocument(List<Integer> Oids);
}
