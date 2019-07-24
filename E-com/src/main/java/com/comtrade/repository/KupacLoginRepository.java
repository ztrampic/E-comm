package com.comtrade.repository;

import com.comtrade.entiteti.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KupacLoginRepository extends JpaRepository<Kupac, Integer> {

    @Query(value = "SELECT * FROM `kupac` WHERE email =:email AND password =:password",nativeQuery = true)
    Kupac tryLogin(@Param("email") String email,@Param("password") String password);
}
