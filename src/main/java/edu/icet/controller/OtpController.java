package edu.icet.controller;

import edu.icet.dto.OtpRequest;
import edu.icet.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/auth")
public class OtpController {
    @Autowired
    private OtpService otpService;

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");
        otpService.sendOtp(email);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify-otp")
    public boolean verifyOtp(@RequestBody OtpRequest otpRequest) {
        return otpService.verifyOtp(otpRequest.getEmail(), otpRequest.getOtpCode());
    }
}
