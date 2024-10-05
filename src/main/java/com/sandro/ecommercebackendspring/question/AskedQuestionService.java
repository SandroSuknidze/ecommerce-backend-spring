package com.sandro.ecommercebackendspring.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AskedQuestionService {
    
    private final AskedQuestionRepository askedQuestionRepository;
    
    public void createAskedQuestion(AskedQuestionDTO request) {
        AskedQuestion askedQuestion = new AskedQuestion();
        askedQuestion.setName(request.getName());
        askedQuestion.setEmail(request.getEmail());
        askedQuestion.setPhone(request.getPhone());
        askedQuestion.setComment(request.getComment());

        askedQuestionRepository.save(askedQuestion);
    }

}
