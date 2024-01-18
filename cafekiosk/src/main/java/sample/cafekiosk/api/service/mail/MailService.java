package sample.cafekiosk.api.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.api.domain.history.mail.MailSendHistory;
import sample.cafekiosk.api.domain.history.mail.MailSendHistoryRepository;
import sample.cafekiosk.client.mail.MailSendClient;

//메일 전송 후 히스토리를 남겨두는 서비스
@RequiredArgsConstructor
@Service
public class MailService {
    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;
    public boolean sendMail(String fromEmail, String toEmail, String subject, String content) {
        boolean result = mailSendClient.sendEmail(fromEmail, toEmail, subject, content);
        if(result){
            //히스토리 저장
            mailSendHistoryRepository.save(MailSendHistory.builder()
                    .fromEmail(fromEmail)
                    .toEmail(toEmail)
                    .subject(subject)
                    .content(content)
                    .build());
            return true;
        }
        return false;
    }
}
