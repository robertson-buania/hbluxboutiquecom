package com.buania.buanialaxtechhblux.contact_newsletter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter,Long> {

}
