package lk.earth.accesscontrol.dao;

import lk.earth.accesscontrol.entity.Usecase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsecaseDao extends JpaRepository<Usecase, Integer> {
}
