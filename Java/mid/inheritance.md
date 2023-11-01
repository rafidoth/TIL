## Implementing Inheritance in Java

```java
class MySubclass extends MySuperclass{
    // additional instance variables
    // additional methods
}
```

## Constructor Rules

**Scenerio 1** :
Parent Class has a parameterless constructor and Child class has no constructor. Now if I create an instance of ChildClass then the parameterless constructor of parent class will be called automatically.

```java
class ParentClass{
    public ParentClass(){
        System.out.println("Super/Parent Class constructor is called");
    }
}

class ChildClass extends ParentClass{

}

public class Main{
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
    }
}

```

Output

```
Super/Parent Class constructor is called
```

Again if the child class would have a constructor the parent/super constructor would be still called at the time of instance creation.

```java
class ParentClass{
    public ParentClass(){
        System.out.println("Super/Parent Class constructor is called");
    }
}

class ChildClass extends ParentClass{
    public ChildClass(){
        System.out.println("Sub / Child Class constructor is called");
    }
}

public class Main{
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
    }
}

```

Output

```
Super/Parent Class constructor is called
Sub / Child Class constructor is called
```

**Scenerio 2** :
Parent Class has two Constructor one is parameterless and the other one is parameterized. And the Child Class has a parameterless constructor. In this case also the parameterless Constructor of parent class will be called automatically when instance of Child Class will be created.

```java
class ParentClass{
    public ParentClass(){
        System.out.println("Super/Parent Class constructor is called");
    }

    public ParentClass(int x){
        System.out.println(x +"Parameterized Constructor from ParentClass");
    }
}

class ChildClass extends ParentClass{
    public ChildClass(){
        System.out.println("Sub / Child Class constructor is called");
    }
}

public class Main{
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
    }
}

```

Output:

```
Super/Parent Class constructor is called
Sub / Child Class constructor is called
```

**Scenerio 3** :
If Parent Class has no parameterless constructor (Default Constructor) then the Child Class must call super class with parameter otherwise there will be error caused.

```java
class ParentClass{
    public ParentClass(int x){
        System.out.println(x +"Parameterized Constructor from ParentClass");
    }
}

class ChildClass extends ParentClass{
    public ChildClass(){
        super(10);
        System.out.println("Sub / Child Class constructor is called");
    }
}

public class Main{
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
    }
}
```

Output

```
10Parameterized Constructor from ParentClass
Sub / Child Class constructor is called
```

## Summary of Constructor Rules

There has to be a default constructor in the parent class which will be called during the time of Instance Creation of Child Class. If there is parameterless constructor then it will be called automatically (but its good practice to use super() to call explicitly) and if there is no parameterless constructor in the parent class then we have to use super with parameter to call the existing parameterized constructor of Parent Class.

## Access Control

- use of protected keyword : When protected keyword is used in a method or variable it will only be able to be accessed from **Child Class** or Similar Package

```java
class ParentClass{
    protected int x = 10;
}

class ChildClass extends ParentClass{
    public ChildClass(){
        System.out.println(x);
    }
}

public class Main{
    public static void main(String[] args) {
        ChildClass c = new ChildClass();
        ParentClass p = new ParentClass();
        System.out.println(p.x);
    }
}
```

Output

```
10
10
```

## Method Overriding

Method overriding is simply just creating same method in the child class with new implementation.

```java
class Animal{
    public void hello(){
        System.out.println("hello from Animal");
    }
}

class Dog extends Animal{
    public void hello(){
        System.out.println("hello from Dog");
    }
}

class Husky extends Dog{
    public void hello(){
        System.out.println("hello from Husky");
    }
}

public class Main{
    public static void main(String[] args) {
        Husky h = new Husky();
        h.hello();
    }
}


```

what if there is no hello() method overriding in the Child Class?
When the method is called first it will go to the closest class here Husky then search for the method if its not found then it will go to its parent here Dog and if its there it will provoke it otherwise it will go to its parent which is Animal in this scenerio.

```java
class Animal{
    public void hello(){
        System.out.println("hello from Animal");
    }
}

class Dog extends Animal{
    public void hello(){
        System.out.println("hello from Dog");
    }
}

class Husky extends Dog{

}

public class Main{
    public static void main(String[] args) {
        Husky h = new Husky();
        h.hello();
    }
}
```

Output

```
hello from Dog
```

## Upcasting

Child Class's instance can be kept in Parent Class Reference.

```java
public class Main{
    public static void main(String[] args) {
        Animal husky = new Husky();
        husky.hello();
    }
}
```

As we know parent class dont have access to its child class. So, any methods that are not present in the parent class (Animal) can't be accessed after upcasting.

```java
class Animal{
    public void hello(){
        System.out.println("hello from Animal");
    }
}

class Dog extends Animal{
    public void hello(){
        System.out.println("hello from Dog");
    }
}

class Husky extends Dog{
    public void hello(){
        System.out.println("hello from Husky");
    }
    public void huskyThings(){
        System.out.println("looks stylish");
    }
}

public class Main{
    public static void main(String[] args) {
        Animal husky = new Husky();
        husky.huskyThings(); // We can not do this
    }
}
```

## Downcasting

```java
public class Main{
    public static void main(String[] args) {
        Animal huskyAnimal = new Husky();
        Husky husky = (Husky) huskyAnimal;
        husky.hello();
    }
}
```
