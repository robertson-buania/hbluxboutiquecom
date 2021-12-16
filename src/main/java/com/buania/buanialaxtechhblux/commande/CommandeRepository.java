package com.buania.buanialaxtechhblux.commande;

import com.buania.buanialaxtechhblux.commande.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
