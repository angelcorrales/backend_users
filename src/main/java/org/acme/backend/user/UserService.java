package org.acme.backend.user;

import javax.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import org.acme.backend.dao.dto.*;
import org.acme.backend.user.dto.*;

import org.acme.backend.dao.ServiceDao;

@ApplicationScoped
public class UserService {

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
        List<MissionDto> missions = new ArrayList<>();

        List<UserMissions> list = dao.findMissionsByUser(id);

        list.stream().forEach((p) -> {
            missions.add(addMission(p.getId(),p.getDescription(),p.getImage(),p.getAmount(),"€",p.getState()));
        });

        //missions.add(addMission("Hacer la cama cada día", "bed.jpg", 5.0, "€","ACTIVE"));
        //missions.add(addMission("Jugar a la play el tiempo asignado", "play.jpg", 25.0, "€","ACTIVE"));
        //missions.add(addMission("No pelear con tus hermanos", "study.jpg", 30.0, "€","INACTIVE"));

        return missions;
    }

    private MissionDto addMission(Long id, String description, String image, Double amount, String currency, String state) {
        MissionDto missionDto = new MissionDto();
        missionDto.setId(id.toString());
        missionDto.setDescription(description);
        missionDto.setImage(image);
        missionDto.setAmount(new Amount(amount, currency));
        missionDto.setState(state);
        return missionDto;
    }

}
