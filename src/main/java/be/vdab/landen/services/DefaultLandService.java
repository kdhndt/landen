package be.vdab.landen.services;

import be.vdab.landen.repositories.LandRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DefaultLandService implements LandService {
    private final LandRepository landRepository;

    public DefaultLandService(LandRepository landRepository) {
        this.landRepository = landRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public long findAantal() {
        return landRepository.count();
    }
}
