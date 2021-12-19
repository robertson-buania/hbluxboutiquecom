package com.buania.buanialaxtechhblux.hbevent;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;


public interface HbEventsRepository extends JpaRepository<Hbevent,Long> {
}
