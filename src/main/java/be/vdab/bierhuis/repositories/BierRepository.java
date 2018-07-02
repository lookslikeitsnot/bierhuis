package be.vdab.bierhuis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.bierhuis.entities.Bier;

public interface BierRepository extends JpaRepository<Bier, Long>{

}
