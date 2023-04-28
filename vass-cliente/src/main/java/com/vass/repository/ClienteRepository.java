package com.vass.repository;

import com.vass.entities.ClienteEntity;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {


    @Query("Select c from ClienteEntity c WHERE c.cedula =:cedula")
    Optional<ClienteEntity> findByCedula(String cedula);

}
