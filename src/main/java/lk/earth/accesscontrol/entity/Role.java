package lk.earth.accesscontrol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Role(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "roleList")
    private List<User> userList;

    @ManyToMany
    @JoinTable(
            name = "roleusecase",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "usecase_id")
    )
    private List<Usecase> usecaseList;

}
