package chapter1;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * 猫狗队列
 * Created by malong on 2019-12-28.
 */
public class CatDogQueue {

    private Queue<PetQueue> dogQueue;
    private Queue<PetQueue> catQueue;
    private long count;

    public CatDogQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0L;
    }

    public void add(Pet pet){
        synchronized (this) {
            if (Objects.equals(pet.getType(), "dog")) {
                dogQueue.add(new PetQueue(pet, this.count++));
            } else if (Objects.equals(pet.getType(), "cat")) {
                catQueue.add(new PetQueue(pet, this.count++));
            } else {
                throw new RuntimeException("error,not dog or cat");
            }
        }
    }

    public Pet pollAll(){
        if(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            if(this.dogQueue.peek().getCount() < this.catQueue.peek().getCount()){
                return this.dogQueue.poll().getPet();
            }else {
                return this.catQueue.poll().getPet();
            }
        }else if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Pet pollDog(){
        if(!this.dogQueue.isEmpty()){
            return this.dogQueue.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Pet pollCat(){
        if(!this.catQueue.isEmpty()){
            return this.catQueue.poll().getPet();
        }else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public boolean isEmpty(){
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return this.dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return this.catQueue.isEmpty();
    }



}


class Pet{

    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}


class Dog extends Pet{
    public Dog() {
        super("dog");
    }
}


class Cat extends Pet{
    public Cat() {
        super("cat");
    }
}

class PetQueue{
    private Pet pet;
    private long count;

    public PetQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public long getCount() {
        return count;
    }

    public String getPetType(){
        return this.pet.getType();
    }
}