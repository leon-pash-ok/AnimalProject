package com.leonpasha.corp.animals.factory;

import com.leonpasha.corp.animals.pojo.*;

import java.security.InvalidParameterException;

public class AnimalFactory {
    public AnimalRecord getAnimal(String animalType){
        switch (animalType.toLowerCase()){
            case "chicken": return new Chicken();
            case "turkey": return new Turkey();
            case "duck": return new Duck();
            case "quail": return new Quail();
            case "cow": return new Cow();
            case "horse": return new Horse();
            case "pig": return new Pig();
            case "goat": return new Goat();
            default:
                throw new InvalidParameterException("Invalid animalType: " + animalType);
        }

    }
}
