package dev.pehlivan.airportreservationsystem.repository;

import dev.pehlivan.airportreservationsystem.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
}
