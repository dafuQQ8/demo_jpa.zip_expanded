package ua.testing.demo_jpa.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ua.testing.demo_jpa.entity.RoleType;
import ua.testing.demo_jpa.entity.User;
import ua.testing.demo_jpa.repository.UserRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserServiceTest {
    @Autowired
    private UserRepository userRepository;

    private UserService underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserService(userRepository);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    void getUsers() {
        // given
        User Rivo = new User(
                1L,
                "Rivo",
                "Carapucci",
                "qq@gmail.com",
                RoleType.ROLE_ADMIN);

        User Serge = new User(

                3L,
                "Serge",
                "QQ",
                "qq@gmail.com",
                RoleType.ROLE_ADMIN);

        userRepository.saveAll(Arrays.asList(Rivo, Serge));

        // when
        List<User> users = underTest.getUsers();
        // then

        assertEquals(2, users.size());
    }

    @Test
    void getUser() {
        // given
        User Rivo = new User(
                1L,
                "Rivo",
                "Carapucci",
                "qq@gmail.com",
                RoleType.ROLE_ADMIN);

        userRepository.save(Rivo);

        // when
        User actual = underTest.getUser(1L);

        // then
        assertEquals("Rivo", actual.getFirstName());
        assertEquals("Carapucci", actual.getLastName());
        assertEquals("qq@gmail.com", actual.getEmail());
        assertEquals(RoleType.ROLE_ADMIN, actual.getRole());

    }
}