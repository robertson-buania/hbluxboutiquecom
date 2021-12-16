package com.buania.buanialaxtechhblux.livraison;

import com.buania.buanialaxtechhblux.livraison.Livraison;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivraisonRepository extends JpaRepository<Livraison,Long> {
}
