package com.leonpasha.corp.animals.communication;

import com.leonpasha.corp.animals.command.Command;
import com.leonpasha.corp.animals.factory.AnimalFactory;
import com.leonpasha.corp.animals.parser.ParserLine;
import com.leonpasha.corp.animals.pojo.AnimalRecord;

import java.security.InvalidParameterException;
import java.util.*;
import java.lang.System;

public class Communicator {
    private final Scanner scanner = new Scanner(System.in);
    private final ParserLine parser = new ParserLine();
    private List<AnimalRecord> animals = new LinkedList();

    public void run(){
        System.out.println("Hello!");
        boolean isCommandClose = false;
        while(!isCommandClose){
            isCommandClose = getCommandAndReturnTrueIfNeedClose();
        }
    }

    private boolean getCommandAndReturnTrueIfNeedClose(){
        String line = sendMessageAndGetCommand();
        try{
             if (parser.isOneWord(line)){
                 Command command = parser.parseCommand(line);
                 switch (command){
                     case OVERALL : overall(); break;
                     case CLOSE : return true;
                 }
             }else{
                 addAnimal(line);
             }
        } catch (InvalidParameterException ex){
                System.out.println(ex.getMessage());
        }
        return false;
    }

    private void addAnimal(String line) {
        Map<String, String> parsedMap =  parser.parseStringWithAddedAnimals(line);
        AnimalRecord animalRecord = (new AnimalFactory()).getAnimal(parsedMap.get("typeAnimal"));
        int count = Integer.parseInt(parsedMap.get("count"));
        animalRecord.setCount(count);
        animalRecord.setDate(new Date());
        animals.add(animalRecord);
        System.out.println("line added: " + animalRecord.returnStringAfterAdd());
    }

    private void overall(){
        if (animals.size() == 0){
            System.out.println("List of animals is empty.");
            return;
        }
        System.out.println("List of animals:");
        animals.forEach(animal -> System.out.println(animal.print()));
    }

    private String sendMessageAndGetCommand(){
        System.out.println(" ");
        System.out.println("Enter a command. What do you want to do?");
        System.out.println("Enter line like '{count} {animal}' for add animals (example: 5 chicken):");
        System.out.println("Enter 'c' or 'close' for close program.");
        System.out.println("Enter 'o' or 'overall' for show the list of animals");
        String line = scanner.nextLine();
        System.out.println("You enter: " + line);
        return line;
    }
}
