package com.bbva.play.dao;


import com.bbva.play.dao.client.MissionClient;
import com.bbva.play.dao.dto.*;
import com.bbva.play.dao.entity.UsersMissionsEntity;
import com.bbva.play.user.dto.MissionDto;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class ServiceDao {

    private static final Logger LOGGER = Logger.getLogger(ServiceDao.class);

    @Inject
    @RestClient
    MissionClient missionClient;

    @Transactional(SUPPORTS)
    public List<Users> findAllUsers() {
        return Users.listAll();
    }

    @Transactional(SUPPORTS)
    public Users findUserById(Long id) {
        return Users.findById(id);
    }

    @Transactional(SUPPORTS)
    public List<UsersMissionsEntity> findMissionsByUser(Long id) {
        return UsersMissionsEntity.findByMission(id);
    }

    public List<MissionDto> getMission(List<UsersMissionsEntity> usersMissions) {
        List<String> ids = new ArrayList<>();
        usersMissions.forEach((UsersMissionsEntity item) -> ids.add(String.valueOf(item.getMissionId())));
        LOGGER.info("Se llama al servicio para recuperar informacion de las misiones: "+ids);
        List<MissionDto> out = missionClient.getMission(ids);
        LOGGER.info("Mision devuelta: "+out);
        return out;
    }
}
