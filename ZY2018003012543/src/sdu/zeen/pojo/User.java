package sdu.zeen.pojo;

import java.util.Objects;

public class User {
    private int uid;
    private String user;
    private String password;

    public int getUid() {
        return uid;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", user='" + user + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user1 = (User) o;
        return getUid() == user1.getUid() &&
                Objects.equals(getUser(), user1.getUser()) &&
                Objects.equals(getPassword(), user1.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUid(), getUser(), getPassword());
    }

    public User()
    {
        super();
    }

    public User(int uid, String user, String password) {
        super();
        this.uid = uid;
        this.user = user;
        this.password = password;
    }
}