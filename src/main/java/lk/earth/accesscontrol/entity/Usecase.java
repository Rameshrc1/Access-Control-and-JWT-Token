package lk.earth.accesscontrol.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Usecase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    public Usecase(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "usecaseList")
    private List<Role> roleList;

}
