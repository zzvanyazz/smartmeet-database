package com.lemonado.smartmeet.database.repositories.db;

import com.lemonado.smartmeet.database.data.modes.TimeLineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeLineDatabaseRepository extends CrudRepository<TimeLineEntity, Long> {


    List<TimeLineEntity> findAllByGroup_IdAndUser_Id(long groupId, long userId);

    List<TimeLineEntity> findAllByGroup_Id(long groupId);




}
