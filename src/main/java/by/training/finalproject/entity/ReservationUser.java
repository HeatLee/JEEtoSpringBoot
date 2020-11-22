package by.training.finalproject.entity;

import by.training.finalproject.converter.UserRoleConverter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "reservation_user")
public class ReservationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;
    private String login;
    private String password;
    private String email;
    @Column(name = "user_role_id")
    @Convert(converter = UserRoleConverter.class)
    private UserRole userRole;

    @OneToMany(mappedBy = "reservationUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Request> requestList;

    protected ReservationUser() {
    }

    public ReservationUser(String login, String password, String email, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public ReservationUser(ReservationUser user) {
        this.id = user.id;
        this.login = user.login;
        this.password = user.password;
        this.email = user.email;
        this.userRole = UserRole.getRoleById(user.userRole.getId());
        this.requestList.clear();
        this.requestList.addAll(user.requestList);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        if (requestList != null) {
            for (Request request :
                    requestList) {
                request.setReservationUser(this);
            }
        }
        this.requestList = requestList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationUser user = (ReservationUser) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(userRole, user.userRole);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (userRole != null ? userRole.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
