package demo.delivery_project.token.adapter.out.persistence.mapper;

import demo.delivery_project.jooq.tables.records.AccessTokensRecord;
import demo.delivery_project.token.application.domain.model.AccessToken;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccessTokenJooqMapper {
    AccessToken mapToDomain(AccessTokensRecord record);

    AccessTokensRecord mapToRecord(AccessToken domain);
}
