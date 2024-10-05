package com.sandro.ecommercebackendspring.question;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AskedQuestionRepository extends JpaRepository<AskedQuestion, Long> {

}
