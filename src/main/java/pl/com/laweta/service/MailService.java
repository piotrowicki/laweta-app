package pl.com.laweta.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import pl.com.laweta.dto.MailDto;

@ApplicationScoped
public class MailService {

    private static final String EMAIL_SUBJECT = "Wiadomość od pomocdrogowaostroda.com.pl";
    private static final String EMAIL_BODY = "Dostałeś wiadomość od %s [%s]\n\n%s";

    private final Mailer mailer;

    @ConfigProperty(name = "laweta.admin.mail-primary")
    String primaryMail;

    @ConfigProperty(name = "laweta.admin.mail-secondary")
    String secondaryMail;

    @Inject
    public MailService(Mailer mailer) {
        this.mailer = mailer;
    }

    public boolean sendEmail(MailDto mail) {
        mailer.send(Mail.withText(primaryMail, EMAIL_SUBJECT,
                String.format(EMAIL_BODY, mail.getName(), mail.getEmail(), mail.getText())));
        mailer.send(Mail.withText(secondaryMail, EMAIL_SUBJECT,
                String.format(EMAIL_BODY, mail.getName(), mail.getEmail(), mail.getText())));
        return true;
    }
}
