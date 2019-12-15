package stc21.smartmediator.DTO;

public class Password {
    String password;
    String passwordRepeat;

    public Password() {
    }

    public Password(String password, String passwordRepeat) {
        this.password = password;
        this.passwordRepeat = passwordRepeat;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
