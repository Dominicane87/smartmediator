package stc21.smartmediator.DTO;
import java.util.UUID;

public class Organisation {
    private UUID id;
    private String fullName;
    private String login;
    private String email;
    private String type;
    private String name;
    private String inn;
    private String address;
    private String status;

    public Organisation(UUID id, String fullName, String login, String email, String type, String name, String inn, String address, String status) {
        this.id = id;
        this.fullName = fullName;
        this.login = login;
        this.email = email;
        this.type = type;
        this.name = name;
        this.inn = inn;
        this.address = address;
        this.status = status;
    }

    public Organisation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

