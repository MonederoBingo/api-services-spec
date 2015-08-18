package com.lealpoints.functional_tests;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.lealpoints.functional_tests.model.ServiceResult;
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
        API("http://test.localhost:9090/api"),
        AUTH("http://test.localhost:9090/auth");

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

    protected <T> ServiceResult getServiceResult(HttpMethod httpMethod, CallType callType, String path, T object) {
        Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON_TYPE);
        Response response = getRestResponse(httpMethod, entity, callType, path);
        if (response.getMediaType().getSubtype().equals("json")) {
            String jsonResponse = response.readEntity(String.class);
            return new Gson().fromJson(jsonResponse, ServiceResult.class);
        } else {
            throw new JsonParseException(response.readEntity(String.class));
        }
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
