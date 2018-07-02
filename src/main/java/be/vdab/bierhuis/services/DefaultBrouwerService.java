package be.vdab.bierhuis.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import be.vdab.bierhuis.entities.Brouwer;
import be.vdab.bierhuis.repositories.BrouwerRepository;

@Service
@Transactional(readOnly = true)
public class DefaultBrouwerService implements BrouwerService {
	private final BrouwerRepository brouwerRepository;

	public DefaultBrouwerService(BrouwerRepository brouwerRepository) {
		this.brouwerRepository = brouwerRepository;
	}
	
	@Override
	public List<Brouwer> findAll(){
		return brouwerRepository.findAll();
	}

	@Override
	public Optional<Brouwer> findById(long id) {
		return brouwerRepository.findById(id);
	}
}
