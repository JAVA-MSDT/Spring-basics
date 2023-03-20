package com.rest.servicedb.repository;

import com.rest.dto.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @SpringBootTest
//@ExtendWith(SpringExtension.class)
//@DataJpaTest
//@ContextConfiguration()
//@ActiveProfiles("test")
class UserRepositoryTest {

   // @Autowired
    private UserRepository userRepository;

   // @BeforeEach
    void setUp() {
    }

    //@AfterEach
    void tearDown() {
    }

   // @Test
    public void saveUser() {
        User user = new User(1L, "Admin", "Admin", LocalDate.now());
        User userDb = userRepository.save(user);

        assertEquals(user.getName(), userDb.getName());
    }
}
