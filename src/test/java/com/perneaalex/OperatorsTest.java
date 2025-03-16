package com.perneaalex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsTest {

    @Test
    void add() {
        assertEquals(5, Operators.add(2, 3));
    }

    @Test
    void subtract() {
        assertEquals(5, Operators.subtract(6, 1));
    }

    @Test
    void multiply() {
        assertEquals(12, Operators.multiply(6, 2));
    }

    @Test
    void divide() {
        assertEquals(5, Operators.divide(10, 2));
    }

    @Test
    void pow2() {
        assertEquals(25,Operators.pow2(5));
    }

    @Test
    void pow3() {
        assertEquals(125,Operators.pow3(5));
    }

    @Test
    void powN() {
        assertEquals(36,Operators.powN(6,2));
    }

    @Test
    void sqrt() {
        assertEquals(5,Operators.sqrt(5));
    }

    @Test
    void cbrt() {
        assertEquals(5,Operators.cbrt(125));
    }

    @Test
    void exp() {
        assertEquals(Math.exp(5),Operators.exp(5));
    }

    @Test
    void log() {
        assertEquals(Math.log(3),Operators.log(3));
    }

    @Test
    void ln() {
    }

    @Test
    void sin() {
        assertEquals((1/ Math.sqrt(2)),Operators.sin((Math.PI / 4)));
    }

    @Test
    void asin() {
    }

    @Test
    void cos() {
    }

    @Test
    void acos() {
    }

    @Test
    void tan() {
    }

    @Test
    void atan() {
    }

    @Test
    void fact() {
        assertEquals(720,Operators.fact(5));
    }
}