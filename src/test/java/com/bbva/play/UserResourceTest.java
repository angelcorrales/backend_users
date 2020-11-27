package com.bbva.play;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.bbva.play.dao.dto.Users;
import com.bbva.play.dao.entity.UsersMissionsEntity;

import io.quarkus.panache.mock.PanacheMock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class UserResourceTest {
	
	@BeforeAll
	public static void setUp() {
		PanacheMock.mock(UsersMissionsEntity.class);
		PanacheMock.mock(Users.class);
		
		Users users = new Users();
		users.setAvatar("avatar.jpg");
		Mockito.when(Users.findById(Mockito.any())).thenReturn(users); 

		List<UsersMissionsEntity> listUserMissions = new ArrayList<>();
		listUserMissions.add(addUserMission(1L, 1L, "Pending"));
		listUserMissions.add(addUserMission(2L, 1L, "Active"));
		Mockito.when(UsersMissionsEntity.findByUserId(Mockito.anyLong())).thenReturn(listUserMissions);
	}

	private static UsersMissionsEntity addUserMission(long missionId, long userId, String status) {
		UsersMissionsEntity out = new UsersMissionsEntity();
		out.setMissionId(missionId);
		out.setUserId(userId);
		out.setStatus(status);
		return out;
	}

    @Test
    public void testUserResource() {
       given()
            .when().get("/user/1")
            .then()
            .statusCode(200);
    }
}
