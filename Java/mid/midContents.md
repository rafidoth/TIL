# Contents for mid

## Packages

Package is a directory consisting of classes, sub-classes, interfaces which are closely related

```
java
	- util
		- ArrayList.java
		- LinkedList.java
		- HashMap.java
	- Lang
		- Object.java
		- String.java
```

here `java` is a package, `util` is java’s sub-package and then `ArrayLis` is sub-package of `util` 

So, to create package consisting of some classes we have to put them in the same directory and that directory will be called package. We have to explicitly mention the directory / package name in the classes to make sure that this class is under a particular package. 

## Initializer Block

```java
public class Main {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A{
    public A(){
        System.out.println("hello from constructor");
    }

    {
        System.out.println("hello world from init block");
    }

    static {
        System.out.println("Hello from Static Block ");
    }

}

```

```java
Initializer Block 
------> Static Initializer Block
------> Instance Initializer Block

Static Block > Instance Block > Constructor
```

## Why do we need an instance initializer blocks when we can initialize the variables using a constructor?

Instance initializers are needed in three cases:

1. They are *guaranteed* to be called, even when a *subclass* of your class is being constructed. There is no guarantee that someone who sub-classes your class will call your constructor/s.
    
    ```java
    public class InitBlock {
        public static void main(String[] args) {
            Test obj1 = new Test();
            Test obj2 = new Test_1();
        }
    }
    
    class Test{
        {
            System.out.println("parent class");
        }
    }
    
    class Test_1 extends  Test{
        {
            System.out.println("child class");
        }
    }
    ```
    
2. They avoid duplicated code, if setup is needed in several constructors.
Constructors can only call one other constructor, but you can have any
number of instance initializer blocks.
3. Anonymous inner classes can’t have constructors, but they can have initializers.

## Shades of `this` keyword

- Refer to current class instance variable

```java
public class Hello {
    int a;
    public Hello(int a){
        this.a = a;
    }
}
```

- Current Class Constructor

```java
//scenerio : when object is created without value by default it gets 0 using oop concept

public class Hello {
    private int value;

    public MyClass() {
        this(0); 
    }

    public Hello(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

- Used As a reference to current object

```java
// scenerio :
// Find the object with highest sum from a class

public class Point {
    int x,y;
    static int maxSum = Integer.MIN_VALUE;
    static Point maxPoint;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
        int sum = x+y;
        if(sum > maxSum){
            maxSum = sum;
            //using as current class instance
            maxPoint = this;
        }
    }

    public String toString(){
        return this.x + " " +this.y;
    }

    public String displayMaxPoint(){
        return maxPoint.x + " " + maxPoint.y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,2);
        Point p2 = new Point(4,5);
        Point p3 = new Point(5,9);

        System.out.println(p1.displayMaxPoint());
    }
}
```

## Garbage Collection

[Link for details study 1](https://www.freecodecamp.org/news/garbage-collection-in-java-what-is-gc-and-how-it-works-in-the-jvm/)

[Link for details study 2](https://www.scaler.com/topics/garbage-collection-in-java/)

- De-referencing object
    - by referencing `null`
        
        ```java
        Student student = new Student();
        student = null; 
        ```
        
    - By assigning a reference to another
        
        ```java
        Student studentOne = new Student();
        Student studentTwo = new Student();
        studentOne = studentTwo;
        ```
        
    - By using an anonymous object
        
        ```java
        new Student()
        ```
        
- Local Variable Objects
    
    ```java
    void fun(){
    	Point p = new Point(10,20);
    }
    ```
    
- Island of Isolation
    
    ```java
    Point a = new Point(1,2)
    Point b = new Point (3,4)
    
    a = b;
    b = a;
    // a got lost
    
    ```
    

## Encapsulation

Encapsulating something that means protecting something.

```java
// use private keyword to keep the access between class only

// Encapsulated
public class Person {
    private String name;
    private int age;
    public Person(int age, String name){
       this.name = name;
       this.age = age;
    }
}

class TestClass{
    public static void main(String[] args) {
       Person p1 = new Person(20,Rafi);
       p1.age = 23; //error ----> age is private
       p1.name = "Rafiul Hasan" //error -------> name is private
    }
}
```

Solution for accessing and setting values.

```java
public class Person {
    private String name;
    private int age;
    public Person(int age, String name){
       this.name = name;
       this.age = age;
    }

    //getter
    public String getName(){
        return this.name;
    }
    public int getAge(){
        return this.age;
    }

		//setter
    public void setAge(int age){
        this.age = age;
    }
    public void setName(String name){
        this.name = name;
    }
}

class TestClass{
    public static void main(String[] args) {
       Person p1 = new Person(20,"Rafi");
       p1.setAge(23);
       p1.setName("Rafiul Hasan");
    }
}
```

## Abstraction

- No object can be created from `abstract`classes
- Use `abstract`keyword for defining abstract class
- Abstract class can have both  regular and irregular methods
- Abstract method does not have a body
- Abstract class must have at least one abstract method
- Reference can be created of Abstract Classes