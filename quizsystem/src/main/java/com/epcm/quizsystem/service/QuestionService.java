package com.epcm.quizsystem.service;

import com.epcm.quizsystem.Question;
import com.epcm.quizsystem.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions() {
        return questionDao.findAll();

    }

    public List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }
}