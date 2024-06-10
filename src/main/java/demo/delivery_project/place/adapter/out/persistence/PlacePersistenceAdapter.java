package demo.delivery_project.place.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.place.adapter.out.persistence.entity.PlaceJpaEntity;
import demo.delivery_project.place.adapter.out.persistence.mapper.PlacePersistenceMapper;
import demo.delivery_project.place.adapter.out.persistence.repository.PlaceRepository;
import demo.delivery_project.place.application.domain.model.Place;
import demo.delivery_project.place.application.usecase.out.DeletePlaceOutPort;
import demo.delivery_project.place.application.usecase.out.GetPlaceOutPort;
import demo.delivery_project.place.application.usecase.out.SavePlaceOutPort;
import demo.delivery_project.place.application.usecase.out.UpdatePlaceOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PlacePersistenceAdapter implements SavePlaceOutPort, GetPlaceOutPort, UpdatePlaceOutPort, DeletePlaceOutPort {
    private final PlaceRepository placeRepository;
    private final PlacePersistenceMapper placePersistenceMapper;

    @Override
    public Place save(Place domain) {
        PlaceJpaEntity jpaEntity = placeRepository.save(placePersistenceMapper.mapToEntity(domain));
        return placePersistenceMapper.mapToDomain(jpaEntity);
    }

    @Override
    public List<Place> saveAll(List<Place> places) {
        List<PlaceJpaEntity> entities = placeRepository.saveAll(placePersistenceMapper.mapToEntity(places));
        return placePersistenceMapper.mapToDomain(entities);
    }

    @Override
    public Place update(Place domain) {
        return save(domain);
    }

    @Override
    public Place get(UUID id) {
        Optional<PlaceJpaEntity> optionalPlaceJpa = placeRepository.findById(id);
        if (optionalPlaceJpa.isEmpty())
            throw new DataNotFoundException(ErrorMessages.REGION_NOT_FOUND);
        return placePersistenceMapper.mapToDomain(optionalPlaceJpa.get());
    }

    @Override
    public List<Place> getByRegionId(UUID regionId) {
        List<PlaceJpaEntity> placesJpa = placeRepository.findAllByRegion_Id(regionId);
        return placePersistenceMapper.mapToDomain(placesJpa);
    }

    @Override
    public List<Place> getAllByIds(List<UUID> uuids) {
        List<PlaceJpaEntity> placeJpaEntities = placeRepository.findAllById(uuids);
        return placePersistenceMapper.mapToDomain(placeJpaEntities);
    }

    @Override
    public Boolean existsByName(String name) {
        return placeRepository.existsByName(name);
    }

    @Override
    public Page<Place> getAll(Pageable pageable) {
        Page<PlaceJpaEntity> all = placeRepository.findAll(pageable);
        List<Place> places = placePersistenceMapper.mapToDomain(all.getContent());
        return new PageImpl<>(places, pageable, all.getTotalElements());
    }

    @Override
    public void delete(UUID id) {
        placeRepository.deleteById(id);
    }
}
