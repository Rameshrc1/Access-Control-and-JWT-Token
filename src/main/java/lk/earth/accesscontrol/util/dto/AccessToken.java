package lk.earth.accesscontrol.util.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lk.earth.accesscontrol.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AccessToken {

    private String token;
    private LocalDateTime tokenpirs;

    @JsonIgnoreProperties({"failedattempts", "password", "tolocked", "userstatus", "roleList"})
    private User user;
}
