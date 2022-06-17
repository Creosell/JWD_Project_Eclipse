package by.sheshko.shop.bean;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Objects;

public class UserSessionInfo implements Serializable {
    private static final long serialVersionUID = 6002381332695658427L;
    private String login;
    private String name;
    private HttpSession session;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserSessionInfo() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public void signOut() {
        this.login = null;
        this.name = null;
        this.session = null;
        this.password = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSessionInfo that = (UserSessionInfo) o;
        return Objects.equals(login, that.login) && Objects.equals(name, that.name) && Objects.equals(session, that.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, name, session);
    }
}
