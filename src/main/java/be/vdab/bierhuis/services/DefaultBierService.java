package be.vdab.bierhuis.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.bierhuis.entities.Bier;
import be.vdab.bierhuis.repositories.BierRepository;

@Service
@Transactional(readOnly = true)
public class DefaultBierService implements BierService{
	private final BierRepository bierRepository;

	public DefaultBierService(BierRepository bierRepository) {
		this.bierRepository = bierRepository;
	}
	
	@Override
	public long count() {
		return bierRepository.count();
	}

	@Override
	public Optional<Bier> findById(long id) {
		return bierRepository.findById(id);
	}
}
