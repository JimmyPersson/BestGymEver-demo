package com.company;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GymMethodsTest {

    @Test
    void generateArray() {
        GymMethods test = new GymMethods();
        List <Person>test2 = test.generateArray();
        assertEquals(14, test2.size());
        assertNotEquals(15, test2.size());

    }

    @Test
    void searchForMember() {
        GymMethods test = new GymMethods();
        List<Person> test2 = test.generateArray();
        String name = test2.get(3).getName();
        assertEquals("Diamanda Djedi", name);
    }

    @Test
    void checkDate() {
        GymMethods test = new GymMethods();
        List<Person> test2 = test.generateArray();
        assertTrue(test.checkDate(test2.get(3)));
        assertFalse(test.checkDate(test2.get(1)));
    }

    @Test
    void updateFile() {
    }
}