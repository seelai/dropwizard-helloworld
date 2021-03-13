package com.example.helloworld.resources;

import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.testing.junit5.ResourceExtension;
import org.eclipse.jetty.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.core.Response;

@ExtendWith(DropwizardExtensionsSupport.class)
class FibonacciCalculationResourceTest {

    private static final ResourceExtension EXT = ResourceExtension.builder()
            .addResource(new FibonacciCalculationResource()).build();

    @Test
    void testInvalidNumRangeMin() {
        final Response response = EXT.target("/fibonacci-calculation")
                                    .queryParam("num", 0).request().get();

        Assertions.assertEquals(HttpStatus.BAD_REQUEST_400, response.getStatusInfo().getStatusCode());
    }

    @Test
    void testInvalidNumRangeMax() {
        final Response response = EXT.target("/fibonacci-calculation")
                .queryParam("num", 101).request().get();
        Assertions.assertEquals(HttpStatus.BAD_REQUEST_400, response.getStatusInfo().getStatusCode());
    }

    @Test
    void testValidNumRange() {
        final Response response = EXT.target("/fibonacci-calculation")
                .queryParam("num", 6).request().get();
        Assertions.assertEquals(HttpStatus.OK_200, response.getStatusInfo().getStatusCode());


    }

}