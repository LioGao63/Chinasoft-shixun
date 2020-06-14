package com.chinasoft.controller;

import com.chinasoft.pojo.Document;
import com.chinasoft.service.impl.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DocumentController {

    @Autowired
    DocumentServiceImpl documentService;

    @RequestMapping("/getAllDocument")
    public ModelAndView selectAll(){
        List<Document> documents = documentService.selectAll();
        ModelAndView mav = new ModelAndView();
        mav.addObject("DocumentList", documents);
        mav.setViewName("document/document");
        return mav;
    }

    @RequestMapping("/addDocument")
    public String addDocument(Document document){
        documentService.addDocument(document);
        return "redirect:/getAllDocument";
    }

    @RequestMapping("/updateDocument")
    public String updateDocument(Document document){
        documentService.updateDocument(document);
        return "redirect:/getAllDocuent";
    }

    @RequestMapping("/deleteDocument")
    public String deleteDocument(List<Long> Oids){
        documentService.deleteDocument(Oids);
        return "redirect:/getAllDocument";
    }

    @RequestMapping("/selectByParam")
    public ModelAndView selectByParam(Document document){
        List<Document> documents = documentService.selectByParam(document);
        ModelAndView mav = new ModelAndView();
        mav.addObject("DocumentList", documents);
        mav.setViewName("document/document");
        return mav;
    }

    @RequestMapping("/selectOne")
    public String selectOne(int Oid){
        documentService.selectOne(Oid);
        return "redirect:/showUpdateDocument";
    }

}
