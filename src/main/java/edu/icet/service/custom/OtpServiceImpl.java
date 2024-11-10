package edu.icet.service.custom;

import edu.icet.entity.OtpEntity;
import edu.icet.repository.OtpRepository;
import edu.icet.service.OtpService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {
    private static final Logger logger = LoggerFactory.getLogger(OtpServiceImpl.class);
    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private JavaMailSender mailSender;

    private static final int OTP_EXPIRATION_MINUTES = 10;

    public void sendOtp(String email) {
        String otpCode = generateOtp();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(OTP_EXPIRATION_MINUTES);

        logger.info("Sending OTP to email: {}", email.trim()); // Log the email

        // Save OTP to the database
        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setEmail(email.trim());
        otpEntity.setOtpCode(otpCode);
        otpEntity.setExpirationTime(expirationTime);
        otpRepository.save(otpEntity);

        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        String trimmedEmail = email.trim();
        if (isValidEmail(trimmedEmail)) {
            message.setTo(trimmedEmail);
            message.setSubject("Your OTP Code");
            message.setText("Your OTP is: " + otpCode);
            mailSender.send(message);
        } else {
            logger.error("Invalid email format for OTP: {}", trimmedEmail); // Log invalid email
            System.out.println("Error found in otp");
        }
    }

    public boolean verifyOtp(String email, String otpCode) {
        logger.info("Verifying OTP for email: {}", email); // Log OTP verification

        Optional<OtpEntity> otpOptional = otpRepository.findByEmailAndOtpCode(email, otpCode);
        if (otpOptional.isPresent()) {
            OtpEntity otpEntity = otpOptional.get();
            if (otpEntity.getExpirationTime().isAfter(LocalDateTime.now())) {
                otpRepository.delete(otpEntity); // Delete OTP after successful verification
                logger.info("OTP verified successfully for email: {}", email); // Log success
                return true;
            }
        }

        logger.warn("OTP verification failed for email: {}", email); // Log failure
        return false;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email != null && email.matches(emailRegex);
    }

    public String generateOtp() {
        return String.format("%04d", new Random().nextInt(10000));
    }

}
