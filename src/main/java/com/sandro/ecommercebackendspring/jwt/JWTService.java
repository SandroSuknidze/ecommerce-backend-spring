package com.sandro.ecommercebackendspring.jwt;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    public String createToken() {
        return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6Imdpb3JnaUBnbWFpbC5jb20iLCJpYXQiOjE1MTYyMzkwMjJ9.W_MgZ51XFCpcDTrP67yiuE7wyT2FcrpLMnfTEFjEp4g";
    }
}
