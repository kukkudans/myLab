package com.harilal.java.v8.samples;

public class Sample5 {

	public static void main(String[] args) {
		
		System.out.println("ANIMAL\n-------------------------");
		Animal tigerJohn = new Tiger();
		tigerJohn.eat();
		tigerJohn.features();
		
		System.out.println("HUMAN\n-------------------------");
		Animal human = new Human();
		human.eat();
		human.features();
	}

}

class Human implements HerbivorousAnimal, CarnivorousAnimal {
	public void eat() {
		System.out.println("Some humans are Carnivorous and some are not");
	}

	@Override
	public void features() {
		HerbivorousAnimal.behaviour();

		HerbivorousAnimal.super.eat();
		CarnivorousAnimal.super.eat();
	}
}

class Deer implements HerbivorousAnimal {

	@Override
	public void features() {
		System.out.println("MOVE: Deer moves very fast");
	}

}

class Tiger implements CarnivorousAnimal {

	@Override
	public void features() {
		System.out.println("MOVE: Tiger run very very fast, swims fast and climb trees as well");
	}

}

interface Animal {
	public void features();

	default void eat() {
		System.out.println("EAT: Animals eats food only if they are hungry!!");
	}
}

interface CarnivorousAnimal extends Animal {
	default void eat() {
		System.out.println("CarnivorousAnimal eats other kinds of animals");
	}

	static void behaviour() {
		System.out.println("CarnivorousAnimals behaviour is unpredictable");
	}
}

interface HerbivorousAnimal extends Animal {
	default void eat() {
		System.out.println("Herbivorous are vegetarian animals");
	}

	static void behaviour() {
		System.out.println("CarnivorousAnimals behaviour is predictable");
	}
}