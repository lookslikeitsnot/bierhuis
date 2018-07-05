package be.vdab.bierhuis.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.bierhuis.entities.Brouwer;

public interface BrouwerRepository extends JpaRepository<Brouwer, Long>{
	Page<Brouwer> findAll(Pageable pageable);
}
