package demo.delivery_project.region.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.common.exception.NotAcceptableException;
import demo.delivery_project.common.util.JsonMapper;
import demo.delivery_project.region.adapter.out.persistence.entity.RegionJpaEntity;
import demo.delivery_project.region.adapter.out.persistence.mapper.RegionPersistenceMapper;
import demo.delivery_project.region.adapter.out.persistence.repository.RegionJooqRepository;
import demo.delivery_project.region.adapter.out.persistence.repository.RegionRepository;
import demo.delivery_project.region.application.domain.model.Region;
import demo.delivery_project.region.application.domain.model.RegionWithPlaceProjection;
import demo.delivery_project.region.application.usecase.out.DeleteRegionOutPort;
import demo.delivery_project.region.application.usecase.out.GetRegionOutPort;
import demo.delivery_project.region.application.usecase.out.SaveRegionOutPort;
import demo.delivery_project.region.application.usecase.out.UpdateRegionOutPort;
import lombok.RequiredArgsConstructor;
import org.jooq.JSON;
import org.jooq.Record3;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegionPersistenceAdapter implements SaveRegionOutPort, GetRegionOutPort, UpdateRegionOutPort, DeleteRegionOutPort {
    private final RegionRepository regionRepository;
    private final RegionJooqRepository regionJooqRepository;
    private final RegionPersistenceMapper regionPersistenceMapper;

    @Override
    public Region save(Region domain) {
        if (regionRepository.existsByName(domain.getName()))
            throw new NotAcceptableException(ErrorMessages.REGION_NAME_ALREADY_EXISTS);
        RegionJpaEntity jpaEntity = regionRepository.save(regionPersistenceMapper.mapToEntity(domain));
        return regionPersistenceMapper.mapToDomain(jpaEntity);
    }

    @Override
    public Region update(Region domain) {
        return save(domain);
    }

    @Override
    public Region get(UUID id) {
        Optional<RegionJpaEntity> optionalRegionJpa = regionRepository.findById(id);
        if (optionalRegionJpa.isEmpty())
            throw new DataNotFoundException(ErrorMessages.REGION_NOT_FOUND);
        return regionPersistenceMapper.mapToDomain(optionalRegionJpa.get());
    }

    @Override
    public Boolean existsById(UUID id) {
        return regionRepository.existsById(id);
    }

    @Override
    public Page<Region> getAll(Pageable pageable) {
        Page<RegionJpaEntity> all = regionRepository.findAll(pageable);
        List<Region> regions = regionPersistenceMapper.mapToDomain(all.getContent());
        return new PageImpl<>(regions, pageable, all.getTotalElements());
    }

    @Override
    public List<RegionWithPlaceProjection> getAllWithPlaces() {
        List<Record3<UUID, String, JSON>> places = regionJooqRepository.getAllWithPlaces();
        List<RegionWithPlaceProjection> result = new ArrayList<>();
        places.forEach(place -> {
            result.add(new RegionWithPlaceProjection(
                    place.component1(),
                    place.component2(),
                    JsonMapper.mapFromJson(place.component3().toString(), List.class)
            ));
        });
        return result;
    }

    @Override
    public void delete(UUID id) {
        regionRepository.deleteById(id);
    }
}
