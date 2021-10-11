package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

                private ArrayList GenerateArray(){

        ArrayList memberList = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jimmy\\IdeaProjects\\BestGymEver\\src\\com\\company\\customers.txt"));
            String line;
            while ((line = br.readLine()) != null){
                memberList.add(line);
                                  }


        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Kan inte hitta någon medlemslista att läsa ifrån.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Något blev fel.");
        }
        return memberList;
    }


    private void CompareList(){



    }
}

