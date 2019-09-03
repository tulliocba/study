package io.tulliocba.springbootresthibernate;

import io.tulliocba.springbootresthibernate.model.User;
import static org.assertj.core.api.Assertions.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ScheduledExecutorService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootRestHibernateApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringCrudTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static String USER_ENDPOINT = "/api/v1/users";

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void test_get_all_users() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = testRestTemplate.exchange(getRootUrl() + USER_ENDPOINT,
                HttpMethod.GET, httpEntity, String.class);

        assertThat(response.getBody()).isNotBlank();
        assertThat(response.getStatusCode() == HttpStatus.OK);
    }

    @Test
    public void test_find_user_by_id() {
        User user = testRestTemplate.getForObject(getRootUrl() + USER_ENDPOINT + "/1", User.class);

        assertThat(user.getFirstName()).isEqualTo("Tulio");
        assertThat(user.getLastName()).isEqualTo("Gabriel");
    }

    @Test
    public void test_create_user() {
        User user = new User("admin", "admin", "admin@teste.com", "admin", "admin");

        ResponseEntity<User> userResponseEntity = testRestTemplate.postForEntity(getRootUrl() + USER_ENDPOINT, user, User.class);

        assertThat(userResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(userResponseEntity.getBody()).isNotNull();

        assertThat(userResponseEntity.getBody().getId()).isEqualTo(2L);

    }

    @Test
    public void test_update_user() {
        User user = testRestTemplate.getForObject(getRootUrl() + USER_ENDPOINT + "/1", User.class);
        user.setLastName("Gabriel da Silva");

        testRestTemplate.put(getRootUrl() + USER_ENDPOINT + "/1", user);

        User userUpdated = testRestTemplate.getForObject(getRootUrl() + USER_ENDPOINT + "/1", User.class);

        assertThat(userUpdated.getLastName()).isEqualTo(user.getLastName());
    }

    @Test
    public void test_delete_user() {
        User user = testRestTemplate.getForObject(getRootUrl() + USER_ENDPOINT + "/1", User.class);

        assertThat(user).isNotNull();

        testRestTemplate.delete(getRootUrl() + USER_ENDPOINT + "/1");

        User userDeleted = testRestTemplate.getForObject(getRootUrl() + USER_ENDPOINT + "/1", User.class);

        assertThat(userDeleted).isNull();
    }
}
