package lk.earth.accesscontrol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Userstatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Userstatus(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userstatus")
    private List<User> userList;

}
