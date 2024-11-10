package edu.icet.service;

public interface OtpService extends SuperService{
    void sendOtp(String email);
    boolean verifyOtp(String email, String otpCode);
    String generateOtp();
    boolean isValidEmail(String email);
}
