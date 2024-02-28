package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column
    private String names;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String role;

    public User() {
    }


    public User(int ID, String names, String email, String password) {
        this.ID = ID;
        this.names = names;
        this.email = email;
        this.password = password;
    }
    
    public User(String names, String email, String password) {
        this.names = names;
        this.email = email;
        this.password = password;
    }


    public User(String names, String email, String password, String role) {
        this.names = names;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    
    public String getNames() {
        return names;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }

    public String getRole() {
        return role;
    }


    public void setRole(String role) {
        this.role = role;
    } 
      
}
