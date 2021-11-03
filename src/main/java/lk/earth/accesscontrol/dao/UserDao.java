package lk.earth.accesscontrol.dao;

import lk.earth.accesscontrol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

      public User findByUsername(String username);

}
