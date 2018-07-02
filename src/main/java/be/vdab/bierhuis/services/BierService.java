package be.vdab.bierhuis.services;

import java.util.Optional;

import be.vdab.bierhuis.entities.Bier;

public interface BierService {
	long count();
	Optional<Bier> findById(long id);
}
