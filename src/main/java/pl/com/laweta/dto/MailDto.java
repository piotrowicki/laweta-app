package pl.com.laweta.dto;

import java.util.Objects;

public class MailDto {

    private String email;
    private String name;
    private String text;


    public MailDto() {
    }

    public MailDto(String email, String name, String text) {
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MailDto)) {
            return false;
        }
        MailDto mailDto = (MailDto) o;
        return Objects.equals(email, mailDto.email) && Objects.equals(name, mailDto.name)
                && Objects.equals(text, mailDto.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, text);
    }
}
