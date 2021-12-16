package com.buania.buanialaxtechhblux.hbluxclient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface ClienthbluxRepository extends JpaRepository<Clienthblux,Long> {
    public Clienthblux findByNomContains(@Param("name")String name);

    public Clienthblux findByEmailAndMotDePasse(@Param("email")String email,
                                                @Param("password")String password);

}
