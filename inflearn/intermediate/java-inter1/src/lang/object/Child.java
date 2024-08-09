package lang.object;

// 명시적으로 상속받은 부모 클래스가 있으면 Object 클래스를 상속받지 않는다
public class Child extends Parent{ // 명시적 상속
    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}
