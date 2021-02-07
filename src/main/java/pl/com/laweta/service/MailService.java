package pl.com.laweta.service;

import javax.enterprise.context.ApplicationScoped;

import pl.com.laweta.dto.MailDto;

@ApplicationScoped
public class MailService {

    public boolean sendEmail(MailDto mail) {
        return true;
    }
}
