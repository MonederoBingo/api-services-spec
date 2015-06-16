package com.neerpoints.functional_tests.tests;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import com.neerpoints.functional_tests.model.ServiceResult;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;

public class RestApiTest {

    private Client client;

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9090/api").build();
    }

    @Before
    public void setUp() {
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
    }

    @SuppressWarnings("unchecked")
    protected <T, E> ServiceResult<E> getPostResponse(T object, String path) {
        WebTarget target = client.target(getBaseURI()).path(path);
        Invocation.Builder builder = target.request().accept(MediaType.APPLICATION_JSON);
        Entity<T> companyEntity = Entity.entity(object, MediaType.APPLICATION_JSON_TYPE);
        return builder.post(companyEntity).readEntity(ServiceResult.class);
    }
}
