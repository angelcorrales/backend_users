package org.acme.backend.dao;


import org.acme.backend.dao.dto.*;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;
import io.quarkus.panache.common.*;


import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@ApplicationScoped
@Transactional(REQUIRED)
public class ServiceDao {

    @Transactional(SUPPORTS)
    public List<Users> findAllUsers() {
        return Users.listAll();
    }

    @Transactional(SUPPORTS)
    public Users findUserById(Long id) {
        return Users.findById(id);
    }

    @Transactional(SUPPORTS)
    public List<UserMissions> findMissionsByUser(Long id) {
        //return Users.findById(id);


        //Parameters p = new Parameters();
        //p.and("user", id);
        //UserMission.list("sss", p);

        //UserMission.list("SELECT * FROM usermission WHERE relatedUser = :user",id );
        //return UserMission.list("relatedUser", id);


        return null;
    }


/*
    @Transactional(SUPPORTS)
    public UserDaoDTO findRandomUser() {
        UserDaoDTO randomHero = null;
        while (randomHero == null) {
            randomHero = UserDaoDTO.findRandom();
        }
        return randomHero;
    }*/
/*
    public UserDaoDTO persistUser(@Valid UserDaoDTO hero) {
        UserDaoDTO.persist(hero);
        return hero;
    }*/
/*
    public UserDaoDTO updateHero(@Valid UserDaoDTO hero) {
        UserDaoDTO entity = UserDaoDTO.findById(hero.id);
        entity.name = hero.name;
        entity.last = hero.name;
        entity.name = hero.name;
        entity.name = hero.name;
        entity.name = hero.name;
        return entity;
    }*/
/*
    public void deleteHero(Long id) {
        Hero hero = Hero.findById(id);
        hero.delete();
    }*/
}
