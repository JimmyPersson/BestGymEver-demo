package com.company;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;


public class GymMethods {
  private ArrayList<Person> memberList;
  final Path readPath = Paths.get("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\com\\company\\customers.txt");
  final Path writePath = Paths.get("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\checkin");

    public GymMethods(){ memberList = generateArray();}

    public String inputFromUser() {

        String input = "";
        boolean x = true;
        while (x) {
            input = JOptionPane.showInputDialog("Ange namn eller personnummer på personen som vill träna: ");
            if (input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Du måste ange namn eller personnummer!");
            } else
                x = false;
        }
        return input;
    }

    public ArrayList<Person> generateArray() {
        String name, social, date;
        ArrayList<Person> memberList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(readPath)))) {
            while ((line = br.readLine()) != null) {
                social = line.split(",")[0];
                name = line.split(",")[1];
                date = br.readLine();
                memberList.add(new Person(name.trim(), social.trim(), date.trim()));
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kan inte hitta någon medlemslista att läsa ifrån.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Läsningen av filen stötte på problem.");
        }
        return memberList;
    }


    public Person searchForMember(String input) {

        for (Person person : memberList) {
            if (person.getName().equalsIgnoreCase(input.trim())){
                return person;
            }
            else if (person.getSocial().equals(input.trim())) {
                return person;
            }
        }
        return null;
    }

    public boolean checkDate (Person person){

        LocalDate payment = LocalDate.parse(person.getDate());
        LocalDate yearCheck = payment.plusDays(365);
        if (LocalDate.now().isBefore(yearCheck)) {
            JOptionPane.showMessageDialog(null, "Välkommen in!");
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "Ditt medlemskort är inte giltigt!");
            return false;
        }
    }

    public void createFile (Person person) {


        try (FileWriter fileWriter = new FileWriter(writePath + "\\" + person.getName() + ".txt")) {
            fileWriter.write("Incheckningslista.\n" + "Namn: " + person.getName() + ", " + person.getSocial() + "\n" + LocalDate.now());

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Skrivning till fil stötte på ett problem.");
        }
    }

    public void updateFile(Person person) {

        try (FileWriter fileWriter = new FileWriter(writePath + "\\" + person.getName() + ".txt",true)) {
            fileWriter.write("\n" + LocalDate.now());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Skrivning till fil stötte på ett problem.");
        }
    }

    public void gymRunner() {
        String input;
        Person person = null;

        while (person == null) {
            input = inputFromUser();
            person = searchForMember(input);
        }

        if (checkDate(person)) {
            if (Files.exists(Path.of(writePath + "\\" + person.getName() + ".txt"))) {
                updateFile(person);
            } else {
                createFile(person);
            }
        }
    }
}

