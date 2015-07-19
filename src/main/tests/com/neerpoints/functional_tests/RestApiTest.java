package com.neerpoints.functional_tests;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.neerpoints.functional_tests.model.ServiceResult;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.Before;

public class RestApiTest {
    static private Client client;

    @Before
    public void setUp() {
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
    }

    protected enum CallType {
        API("http://localhost:9090/api"),
        AUTH("http://localhost:9090/auth");

        private final String url;

        CallType(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }

    protected enum HttpMethod {
        GET,
        POST,
        PUT,
        DELETE,
        HEAD,
        OPTIONS;
    }


    protected <T, E> ServiceResult<E> getServiceResult(HttpMethod httpMethod, CallType callType, String path, T object) {
        Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON_TYPE);
        Response response = getRestResponse(httpMethod, entity, callType, path);
        GenericType<ServiceResult<E>> genericType = new GenericType<ServiceResult<E>>() {};
        return response.readEntity(genericType);
    }

    private <T> Response getRestResponse(HttpMethod httpMethod, Entity<T> entity, CallType callType, String path) {
        WebTarget target = client.target(callType.getUrl()).path(path);
        Invocation.Builder builder = target.request().accept(MediaType.APPLICATION_JSON);
        switch (httpMethod) {
            case GET:
                return builder.get();
            case POST:
                return builder.post(entity);
            case PUT:
                return builder.put(entity);
            case DELETE:
                return builder.delete();
            case HEAD:
                return builder.head();
            case OPTIONS:
                return builder.options();
            default:
                throw new IllegalArgumentException("Http method not found: " + this);
        }
    }
}
