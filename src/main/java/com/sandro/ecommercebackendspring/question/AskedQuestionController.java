package com.sandro.ecommercebackendspring.question;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AskedQuestionController {

    private final AskedQuestionService askedQuestionService;

    @PostMapping("/ask-question")
    public ResponseEntity<?> askQuestion(
            @Valid @RequestBody AskedQuestionDTO request,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldErrors().stream()
                    .collect(Collectors.toMap(
                            fieldError -> fieldError.getField(),
                            fieldError -> fieldError.getDefaultMessage()
                    ))
            );
        }

        try {
            askedQuestionService.createAskedQuestion(request);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


        return ResponseEntity.ok(
                Map.of(
                        "message", "Question submitted successfully"
                )
        );
    }

}
