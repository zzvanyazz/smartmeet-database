package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.GroupUserEntity;
import com.lemonado.smartmeet.database.data.modes.GroupUserId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupUserDatabaseRepository extends CrudRepository<GroupUserEntity, GroupUserId> {

    List<GroupUserEntity> findAllByGroup_Id(long groupId);

    List<GroupUserEntity> findAllByUser_Id(long userId);

}
