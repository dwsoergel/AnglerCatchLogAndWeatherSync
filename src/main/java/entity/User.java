package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    // Relationship 1: User has many catch logs
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<CatchLog> catchLogs = new ArrayList<>();

    // Relationship 2: User has many tackle items
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TackleItem> tackleItems = new ArrayList<>();

    public User() {

    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Helper methods for Relationship 1 (CatchLogs)
    public void addCatchLog(CatchLog catchLog) {
        catchLogs.add(catchLog);
        catchLog.setUser(this);
    }

    public void removeCatchLog(CatchLog catchLog) {
        catchLogs.remove(catchLog);
        catchLog.setUser(null);
    }

    // Helper methods for Relationship 2 (TackleItems)
    public void addTackleItem(TackleItem tackleItem) {
        tackleItems.add(tackleItem);
        tackleItem.setUser(this);
    }

    public void removeTackleItem(TackleItem tackleItem) {
        tackleItems.remove(tackleItem);
        tackleItem.setUser(null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<CatchLog> getCatchLogs() {
        return catchLogs;
    }

    public void setCatchLogs(List<CatchLog> catchLogs) {
        this.catchLogs = catchLogs;
    }

    public List<TackleItem> getTackleItems() {
        return tackleItems;
    }

    public void setTackleItems(List<TackleItem> tackleItems) {
        this.tackleItems = tackleItems;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
