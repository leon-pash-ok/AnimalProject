package com.leonpasha.corp.animals.parser;

import com.leonpasha.corp.animals.command.Command;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;

public class ParserLine {
    private void checkString(String line){
        if (line == null)
            throw new InvalidParameterException("Command line is null");
        if (line.trim().equals(""))
            throw new InvalidParameterException("Command line is empty");
    }

    public Command parseCommand(String line) {
        checkString(line);
        switch (line.toLowerCase()) {
            case "c": return Command.CLOSE;
            case "close": return Command.CLOSE;
            case "o": return Command.OVERALL;
            case "overall": return Command.OVERALL;
            default:
                throw new InvalidParameterException("Invalid command line: " + line);
        }
    }

    public Map<String, String> parseStringWithAddedAnimals(String line) {
        checkString(line);
        String trimmedLine = line.trim();
        if (!trimmedLine.contains(" ")){
            throw new InvalidParameterException("Invalid line. Line does not contain space between 2 words: " + line);
        }
        Map<String, String> map = new HashMap();
        String arr[] = trimmedLine.split(" ", 2);
        try{
            Integer.parseInt(arr[0]);
            map.put("count", arr[0]);
            map.put("typeAnimal", arr[1]);
        }catch (NumberFormatException ex){
            throw new InvalidParameterException("Invalid first parameter. " + arr[0] + "is not integer.");
        }
        return map;
    }

    public boolean isOneWord(String line){
        checkString(line);
        String trimmedLine = line.trim();
        return !trimmedLine.contains(" ");

    }
}
