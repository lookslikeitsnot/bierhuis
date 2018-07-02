package be.vdab.bierhuis.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
