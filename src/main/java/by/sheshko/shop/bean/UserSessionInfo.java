package by.sheshko.shop.bean;

import javax.servlet.http.HttpSession;
import java.io.Serializable;

public class UserSessionInfo implements Serializable {
    private static final long serialVersionUID = 6002381332695658427L;
    private String name;
    private int userId;
    private HttpSession session;


    public UserSessionInfo() {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(final int userId) {
        this.userId = userId;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(final HttpSession session) {
        this.session = session;
    }

    public void signOut() {
        this.name = null;
        this.session = null;
    }
}

