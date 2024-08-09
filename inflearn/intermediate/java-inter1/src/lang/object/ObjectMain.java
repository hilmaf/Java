package lang.object;

public class ObjectMain {
    public static void main(String[] args) {
        Child child = new Child();
        child.childMethod();
        child.parentMethod();

        // toString()은 Object 클래스의 메서드
        // Child 객체에서 toString()을 호출하면, Child - Parent - Object 순으로 메서드를 탐색하여 실행
        String string = child.toString(); // toString(): 객체 정보 String화: 클래스명, 인스턴스정보
        System.out.println(string);

        /**
         * 모든 클래스가 Object 클래스를 상속 받는 이유
         * 1. 공통 기능 제공 : 객체의 정보를 제공하는 toString(), 객체의 같음을 비교하는 equals(), 객체의 클래스 정보를 제공하는 getClass() 등
         * 2. 다형성의 기본 구현 : 모든 객체 참조 가능. 모든 자바 객체는 Object 타입으로 처리될 수 있으며, 이는 다양한 타입의 객체를 통합저긍로 처리할 수 있게 함
         */
    }
}
