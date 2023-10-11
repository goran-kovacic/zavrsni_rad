package printApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class User extends Entitet {

    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
