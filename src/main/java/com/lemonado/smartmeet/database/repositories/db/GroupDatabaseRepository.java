package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface GroupDatabaseRepository extends CrudRepository<GroupEntity, Long> {

    boolean existsByIdAndCreator_Id(long id, long creatorId);

    Optional<GroupEntity> findByCode(String code);

    Set<GroupEntity> findAllByCreator_Id(long id);

}
