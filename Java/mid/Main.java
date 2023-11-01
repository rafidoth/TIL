

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
