package com.sandro.ecommercebackendspring.question;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AskedQuestionDTO {

    @NotBlank(message = "Name is required")
    @Size(max = 30, message = "Name length should not exceed 30 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 300, message = "Email length should not exceed 300 characters")
    private String email;

    @NotBlank(message = "Phone is required")
    @Size(max = 30, message = "Phone length must be between 8 and 30")
    private String phone;

    @NotBlank(message = "Comment is required")
    @Size(max = 320, message = "Comment length should not exceed 320 characters")
    private String comment;
}
