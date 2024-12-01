package com.example.ticketBooking.service;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSendEmailWithAttachment_Success() throws Exception {
        // Arrange
        String to = "recipient@example.com";
        String subject = "Booking Confirmation";
        String body = "Your booking details are attached.";

        MimeMessage mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
        doNothing().when(mailSender).send(any(MimeMessage.class));

        // Act
        emailService.sendEmailWithAttachment(to, subject, body);

        // Assert
        verify(mailSender, times(1)).send(mimeMessage);
        verify(mimeMessage, never()).setContent(any(), any());
    }

    @Test
    public void testGeneratePDFContent() throws IOException, DocumentException {
        // Arrange
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();

        // Act
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.add(new com.itextpdf.text.Paragraph("Test PDF content"));
        document.close();

        // Assert
        assertNotNull(outputStream.toByteArray());
    }

    @Test
    public void testMimeMessageHelperInitialization() throws Exception {
        // Arrange
        MimeMessage mimeMessage = mock(MimeMessage.class);
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        // Act
        helper.setTo("recipient@example.com");
        helper.setSubject("Booking Confirmation");
        helper.setText("Please find your booking details attached.");

        // Assert
        assertNotNull(helper);
    }

}
