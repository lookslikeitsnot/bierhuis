package be.vdab.bierhuis.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import be.vdab.bierhuis.entities.Brouwer;

public interface BrouwerService {
	Page<Brouwer> findAll(Pageable pageable);
	Optional<Brouwer> findById(long id);
}
