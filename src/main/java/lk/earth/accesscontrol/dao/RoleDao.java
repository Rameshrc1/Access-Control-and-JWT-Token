package lk.earth.accesscontrol.dao;

import lk.earth.accesscontrol.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
