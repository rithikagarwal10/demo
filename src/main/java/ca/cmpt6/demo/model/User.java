package ca.cmpt6.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    // private username;
    // private age;
    // static private long total = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String name;
    private int age;

    // setters and getters
    public void setPid(int pid) {
        this.pid = pid;
    }

    public long getPid() {
        return pid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        
        return Integer.toString(this.pid) + this.name + Integer.toString(this.age);
    
    }
    
}
