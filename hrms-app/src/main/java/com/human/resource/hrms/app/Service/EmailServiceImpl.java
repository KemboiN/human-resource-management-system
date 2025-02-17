package com.human.resource.hrms.app.Service;

import com.human.resource.hrms.app.Dto.EmailDetails;
import com.human.resource.hrms.app.Dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService
{
    @Autowired
    private  JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private  String sender;

    @Override
    public void sendEmail(EmailDetails emailDetails)
    {

try {
    SimpleMailMessage message = new SimpleMailMessage(); // creating the email
    message.setTo(emailDetails.getRecipient());
    message.setSubject(emailDetails.getSubject());
    message.setText(emailDetails.getBody());
    message.setFrom(sender);
    javaMailSender.send(message);
}
catch (Exception e)
{
    throw new RuntimeException(e);
}
    }

}
