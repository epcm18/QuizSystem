package com.epcm.quizsystem.service;

import com.epcm.quizsystem.model.Question;
import com.epcm.quizsystem.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }

    public String deleteQuestion(Question question) {
        try{
            questionDao.delete(question);
            return "successfully deleted";
        }catch(Exception e){
            e.printStackTrace();
            return "failed" + e.getMessage();
        }
    }

    public String deleteQuestionByTitle(String questionTitle) {
        // Question question = questionDao.findByQuestionTitle(questionTitle);

        try{
            questionDao.deleteByQuestionTitle(questionTitle);
            return "successfully deleted";
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
