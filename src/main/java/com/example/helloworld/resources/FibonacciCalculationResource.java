package com.example.helloworld.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.helloworld.api.FibonacciCalculationResponse;
import org.hibernate.validator.constraints.Range;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

@Path("/fibonacci-calculation")
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciCalculationResource {

    @GET
    @Timed
    public FibonacciCalculationResponse calculateFibonacci(@Range(min = 1, max = 100) @QueryParam("num") int n) {
        BigInteger[] fSeq = new BigInteger[n];
        BigInteger total = BigInteger.ZERO;

        fSeq[0] = BigInteger.ZERO;

        if (n >= 2) {
            fSeq[1] = BigInteger.ONE;
            total = BigInteger.ONE;
        }

        for (int i = 2; i <= n-1; i++) {
            fSeq[i] = fSeq[i-1].add(fSeq[i-2]);
            total = total.add(fSeq[i]);
        }

        return new FibonacciCalculationResponse(n, total, fSeq);
    }
}
