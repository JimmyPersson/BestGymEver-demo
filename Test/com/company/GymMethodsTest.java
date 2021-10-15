package com.company;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
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
    void createFile () {
        assertFalse(Files.exists(Path.of("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin\\Elmer Ekorrsson.txt")));
        GymMethods test = new GymMethods();
        List<Person> test2 = test.generateArray();
        test.createFile(test2.get(4));
        assertTrue(Files.exists(Path.of("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin\\Elmer Ekorrsson.txt")));
    }

    @Test
    void updateFile() throws IOException {
        Files.writeString(Path.of("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin\\Test Testsson.txt"), "Incheckningslista.\n" +
                "Namn: Test Testsson, 8512060099\n" +
                "2021-10-14");
        GymMethods test = new GymMethods();
        List<Person> test2 = test.generateArray();
        LocalDate time = LocalDate.now();
        assertFalse(Files.readString(Path.of("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin\\Test Testsson.txt")).contains(time.toString()));
        test.updateFile(new Person("Test Testsson", "8512060099", "2021-02-14"));
        assertTrue(Files.readString(Path.of("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin\\Test Testsson.txt")).contains(time.toString()));
    }
}