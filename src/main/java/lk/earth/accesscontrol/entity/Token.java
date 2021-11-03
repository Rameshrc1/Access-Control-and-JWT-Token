package lk.earth.accesscontrol.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime doissued;
    private LocalDateTime doexpired;

    public Token(Integer id) {
        this.id = id;
    }

    @ManyToOne
    private Tokenstatus tokenstatus;

    @ManyToOne
    private User user;

}
