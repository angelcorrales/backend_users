package com.bbva.play.user;

import javax.enterprise.context.ApplicationScoped;

import java.util.List;
import javax.inject.Inject;

import com.bbva.play.dao.dto.*;
import com.bbva.play.dao.entity.UsersMissionsEntity;
import com.bbva.play.user.dto.*;

import org.jboss.logging.Logger;

import com.bbva.play.dao.ServiceDao;

@ApplicationScoped
public class UserService {

    private static final Logger LOGGER = Logger.getLogger(UserDTO.class);

    @Inject
    ServiceDao dao;

    public UserDTO getUser(Long id) {

        Users userdao = dao.findUserById(id);
        UserDTO user = null;
        if (userdao != null){
            user = addUser(userdao.getId() ,userdao.getName(), userdao.getLastname(), userdao.getTotalMoney(), userdao.getAvatar());
        }

        return user;
    }


    private UserDTO addUser(Long id, String name, String lastname, Double totalMoney, String avatar) {
        UserDTO userDTO = new UserDTO();
        //userDTO.setId(id.toString());
        userDTO.setName(name);
        userDTO.setLastname(lastname);
        userDTO.setTotalMoney(new Amount(totalMoney, "€"));
        userDTO.setAvatar(avatar);
        return userDTO;
    }

    public List<MissionDto> getUserMissions(Long id) {
        // Se recupera el listado de misiones del usuario
        List<UsersMissionsEntity> usersMissions = dao.findMissionsByUser(id);

        LOGGER.info("Se recuperan los siguientes elementos del usuario: "+usersMissions);

        // Se recupera informacion de las misiones y las devuelve
        List<MissionDto> missions = dao.getMission(usersMissions);

        // Se añade el estado de las misiones del usuario
        for (int i = 0; i < usersMissions.size(); i++) {
            missions.get(i).setState(usersMissions.get(i).getStatus());
        }
        
        return missions;
    }
}