package be.vdab.landen.repositories;

import be.vdab.landen.domain.Land;
import org.springframework.data.jpa.repository.JpaRepository;

//enkel een interface kan een interface extenden, JpaRepository is een interface
public interface LandRepository extends JpaRepository<Land, String> {
}
