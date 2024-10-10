package org.example;

import java.util.ArrayList;

public class AnimalIterator implements BaseIterator{
    private ArrayList<Animal> pets;
    private int index;
    AnimalIterator(ArrayList<Animal> pets){
        this.pets=pets;
        index=0;
    }

    @Override
    public Animal next(){
        return pets.get(index++);
    }

    @Override
    public boolean hasNext(){
        return index<pets.size();
    }

    @Override
    public void reset(){
        index=0;
    }

}
