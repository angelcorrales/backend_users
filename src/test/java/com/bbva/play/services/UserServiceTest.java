package com.bbva.play.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bbva.play.dao.ServiceDao;
import com.bbva.play.dao.dto.Users;
import com.bbva.play.dao.entity.UsersMissionsEntity;
import com.bbva.play.user.UserService;
import com.bbva.play.user.dto.Amount;
import com.bbva.play.user.dto.MissionDto;
import com.bbva.play.user.dto.UserDTO;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class UserServiceTest {
	
	@Inject
	UserService service;

	@InjectMock
	ServiceDao dao;
	
	@Test
	public void getUserTest() {
		Users user = new Users();
		user.setAvatar("avatar.jpg");
		user.setName("Pedro");
		Mockito.when(dao.findUserById(Mockito.anyLong())).thenReturn(user);
		
		UserDTO response = service.getUser(1L);
		assertEquals(response.getName(), user.getName());
		assertEquals(response.getAvatar(), user.getAvatar());
	}
	
	@Test
	public void getUserMissionsTest() {
		List<UsersMissionsEntity> listUserMissions = new ArrayList<>();
		listUserMissions.add(addUserMission(1L, 1L, "Pending"));
		listUserMissions.add(addUserMission(2L, 1L, "Active"));
		Mockito.when(dao.findMissionsByUser(Mockito.anyLong())).thenReturn(listUserMissions);
		
		List<MissionDto> missions = new ArrayList<>();
		missions.add(addMission(25.0, "1"));
		missions.add(addMission(30.0, "2"));
		Mockito.when(dao.getMission(Mockito.anyList())).thenReturn(missions);
		
		List<MissionDto> response = service.getUserMissions(1L);
		assertEquals(response.size(), missions.size());
		assertEquals(response.get(0).getAmount().getAmount(), missions.get(0).getAmount().getAmount());
	}

	private MissionDto addMission(double amount, String id) {
		MissionDto out = new MissionDto();
		out.setAmount(new Amount(amount, "EUR"));
		out.setId(id);
		return out;
	}

	private UsersMissionsEntity addUserMission(long missionId, long userId, String status) {
		UsersMissionsEntity out = new UsersMissionsEntity();
		out.setMissionId(missionId);
		out.setUserId(userId);
		out.setStatus(status);
		return out;
	}
}
