package be.vdab.bierhuis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.bierhuis.entities.Bestelbon;

public interface BestelbonRepository extends JpaRepository<Bestelbon, Long> {

}