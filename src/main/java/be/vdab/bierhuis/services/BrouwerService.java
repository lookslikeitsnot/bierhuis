package be.vdab.bierhuis.services;

import java.util.List;
import java.util.Optional;

import be.vdab.bierhuis.entities.Brouwer;

public interface BrouwerService {
	List<Brouwer> findAll();
	Optional<Brouwer> findById(long id);
}
