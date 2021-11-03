package lk.earth.accesscontrol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    private Integer failedattempts;
    private LocalDateTime tolocked;

    public User(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Token> tokenList;

    @ManyToOne
    private Userstatus userstatus;

    @ManyToMany
    @JoinTable(
            name = "userrole",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roleList;


}
