package lk.earth.accesscontrol.dao;

import lk.earth.accesscontrol.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenDao extends JpaRepository<Token, Integer> {
}
