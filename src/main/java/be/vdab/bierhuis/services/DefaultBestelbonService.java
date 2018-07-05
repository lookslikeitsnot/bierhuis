package be.vdab.bierhuis.services;

import org.springframework.stereotype.Service;

import be.vdab.bierhuis.entities.Bestelbon;
import be.vdab.bierhuis.repositories.BestelbonRepository;

@Service
public class DefaultBestelbonService implements BestelbonService {
	private final BestelbonRepository bestelbonRepository;

	public DefaultBestelbonService(BestelbonRepository bestelbonRepository) {
		this.bestelbonRepository = bestelbonRepository;
	}

	@Override
	@ModifyingTransactionalServiceMethod
	public void create(Bestelbon bestelbon) {
		bestelbonRepository.save(bestelbon);
	}
}
