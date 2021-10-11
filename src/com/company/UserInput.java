package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class UserInput {
    boolean x = true;
    String input;

    public void InputFromUser() {

                while (x) {

                    input = JOptionPane.showInputDialog("Ange namn eller personnummer på personen som vill träna: ");
                    if (input.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Du måste ange namn eller personnummer!");
                    }
                    else
                        x = false;

                    }
                }
    private void CheckInputWithFile(){

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\com\\company\\customers.txt"));
            String line;
            while ((line = br.readLine()) != null){
                if (line.contains(input)){
                    JOptionPane.showMessageDialog(null, "Välkommen!");}

                    else
                        JOptionPane.showMessageDialog(null, "Get fokt!");

                }


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kan inte hitta någon medlemslista att läsa ifrån.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel.");
        }
    }
}

