package be.vdab.bierhuis.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Brouwer> findAll(Pageable pageable) {
		return brouwerRepository.findAll(pageable);
	}

	@Override
	public Optional<Brouwer> findById(long id) {
		return brouwerRepository.findById(id);
	}
}
