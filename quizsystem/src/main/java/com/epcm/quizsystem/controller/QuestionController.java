package com.epcm.quizsystem.controller;

import com.epcm.quizsystem.model.Question;
import com.epcm.quizsystem.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();

    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion")
    public String deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }

    @DeleteMapping("deleteQuestionByTitle")
    public String deleteQuestionByTitle(@RequestBody String questionTitle){
        return questionService.deleteQuestionByTitle(questionTitle);
    }
}
