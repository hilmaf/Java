package lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    private static void action(Object obj) {
        // obj.sound(); -- 컴파일 오류. Object는 sound()가 없다
        // obj.move(); -- 컴파일 오류. Object는 move()가 없다

        // 그래도 호출하고 싶다면
        // 객체에 맞는 다운 캐스팅 필요
        if(obj instanceof Dog dog) {
            //((Dog)obj)를 안하는 방법
            dog.sound();
        } else if(obj instanceof Car car) {
            car.move();
        }
    }

    // Object를 활용한 다형성의 한계 : 각 객체에 맞는 다운캐스팅 과정 필요
    // 다형성을 제대로 활용하려면 다형적 참조 + 메서드 오버라이딩을 함께 사용해야 한다 => 다형성 활용은 한계
}
