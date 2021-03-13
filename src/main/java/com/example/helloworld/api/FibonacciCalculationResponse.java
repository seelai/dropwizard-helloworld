package com.example.helloworld.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

public class FibonacciCalculationResponse {

    private int memberCount;

    private BigInteger total;

    private BigInteger[] sequence;

    public FibonacciCalculationResponse() {

    }

    public FibonacciCalculationResponse(int memberCount, BigInteger total, BigInteger[] sequence) {
        this.memberCount = memberCount;
        this.total = total;
        this.sequence = sequence;
    }

    @JsonProperty
    public BigInteger getTotal() {
        return total;
    }

    @JsonProperty("member-count")
    public int getMemberCount() {
        return memberCount;
    }

    @JsonProperty
    public BigInteger[] getSequence() {
        return sequence;
    }

}
