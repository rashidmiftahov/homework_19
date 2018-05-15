package ru.innopolis.stc09.education.obj;

public class User {
    private int id;
    private String fullname;
    private int role_id;
    private Role role;
    private String login;
    private String password;

    public User(int id, String login, String password, int role_id) {
        this.id = id;
        this.role_id = role_id;
        this.login = login;
        this.password = password;
    }

    public User(int id, String fullname, int role_id, String login, String password) {
        this.id = id;
        this.fullname = fullname;
        this.role_id = role_id;
        this.login = login;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
