package com.ibapp.service.rest.resource;

import com.ibapp.domain.Person;
import org.junit.Ignore;
import org.junit.Test;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by imranbordiwala on 12/05/2015.
 */

@Ignore
public class PersonResourceTest {

    private org.jboss.resteasy.core.Dispatcher dispatcher;

    @Test
    public void testGetPerson(){

        Response response1 = ClientBuilder.newClient().target("http://localhost:8082").path("/person").request().get();

        assertThat(response1.getStatus(), is(200));

    }

    @Test
    public void testCreatePerson(){

        Person person = new Person();
        person.setFirstName("Test First Name5");
        person.setLastName("Test Last Name5");
        person.setEmail("Test5@Hotmail.com");
        person.setPassword("Test Password5");

        Response response1 = ClientBuilder.newClient().target("http://localhost:8082").path("/person").request().post(Entity.entity(person, MediaType.APPLICATION_JSON));

        assertThat(response1.getStatus(), is(200));
    }

    @Test
    public void testDeletePerson() {

        Response response1 = ClientBuilder.newClient().target("http://localhost:8082").path("/person/1").request().delete();

        assertThat(response1.getStatus(), is(200));

    }

    @Test
    public void testUpdatePerson(){

        Person person = new Person();
        person.setId(4);
        person.setFirstName("Test First Name Updated");
        person.setLastName("Test Last Name Updated");
        person.setEmail("TestUpdated@Hotmail.com");
        person.setPassword("Test Password");

        Response response1 = ClientBuilder.newClient().target("http://localhost:8082").path("/person").request().put(Entity.entity(person, MediaType.APPLICATION_JSON));

        assertThat(response1.getStatus(), is(200));
    }

}
