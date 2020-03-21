package raj.com.securityapps.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name="userId")
    private Integer userId;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="active")
    private Boolean active;

    @Column(name="roles")
    private String roles;
}
