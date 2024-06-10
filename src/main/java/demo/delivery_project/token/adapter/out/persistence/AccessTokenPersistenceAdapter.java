package demo.delivery_project.token.adapter.out.persistence;

import demo.delivery_project.common.exception.DataNotFoundException;
import demo.delivery_project.common.exception.ErrorMessages;
import demo.delivery_project.jooq.tables.records.AccessTokensRecord;
import demo.delivery_project.token.adapter.out.persistence.mapper.AccessTokenJooqMapper;
import demo.delivery_project.token.adapter.out.persistence.repository.AccessTokenJooqRepository;
import demo.delivery_project.token.application.domain.model.AccessToken;
import demo.delivery_project.token.application.usecase.out.DeleteAccessTokenOutPort;
import demo.delivery_project.token.application.usecase.out.GetAccessTokenOutPort;
import demo.delivery_project.token.application.usecase.out.SaveAccessTokenOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccessTokenPersistenceAdapter implements SaveAccessTokenOutPort, GetAccessTokenOutPort, DeleteAccessTokenOutPort {
    private final AccessTokenJooqRepository accessTokenJooqRepository;
    private final AccessTokenJooqMapper accessTokenJooqMapper;

    @Override
    public AccessToken save(AccessToken domain) {
        AccessTokensRecord record = accessTokenJooqRepository.create(accessTokenJooqMapper.mapToRecord(domain));
        return accessTokenJooqMapper.mapToDomain(record);
    }

    @Override
    public AccessToken get(String token) {
        Optional<AccessTokensRecord> recordOptional = accessTokenJooqRepository.get(token);
        if (recordOptional.isEmpty()) throw new DataNotFoundException(ErrorMessages.ACCESS_TOKEN_NOT_FOUND);
        return accessTokenJooqMapper.mapToDomain(recordOptional.get());
    }

    @Override
    public Optional<AccessToken> getOptional(String token) {
        Optional<AccessTokensRecord> recordOptional = accessTokenJooqRepository.get(token);
        return recordOptional.map(accessTokenJooqMapper::mapToDomain);
    }

    @Override
    public void delete(String token) {
        accessTokenJooqRepository.delete(token);
    }
}
