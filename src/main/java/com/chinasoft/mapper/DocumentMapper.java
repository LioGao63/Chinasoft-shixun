package com.chinasoft.mapper;

import com.chinasoft.pojo.Document;

import java.util.List;

public interface DocumentMapper {
	//查询所有
	List<Document> selectAll();

	//增加
	void addDocument(Document document);

	//更新
	void updateDocument(Document document);

	//查询
	List<Document> selectByParam(Document document);


	Document selectOne(int Oid);

	//删除
	void deleteDocument(List<Integer> Oids);
}
