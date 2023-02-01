// 모든 클래스의 생성자 이름은 "constructor" 로 해야함.
// this 넣어야 생성자 함수안에 있는 데이터 사용가능
// 생성자 함수는 오버로딩이 안되기 때문에 2개는 안됨

class Person {
    constructor(name, first, second) { // 얘가 생성자 함수
        this.name = name;
        this.first = first;
        this.second = second;
    };
    sum() { // 클래스 안에서의 function은 펑션빼고 (이름이랑 괄호만) 넣자 
        return this.first + this.second;
    };
};
var hong = new Person('홍길동', 100, 60);
console.log('홍길동의 sum : ', hong.sum()); // 펑션에는 () 괄호 무조건 잊지말자

// -- 상속 --
class PersonPlus extends Person { // Person에 들어있는 데이터 상속 받음 ( name,first,second,sum() )
    constructor(name, first, second, third) { // 생성자 함수는 무조건 ★ constructor
        super(name, first, second); // 부모클래스 생성자 함수 super
        this.third = third;
    }
    sum() {
        return this.first + this.second + this.third; // third를 추가 했기 때문에 sum 펑션을 새로 만듦 2개만 할거면 상속받은거 그대로 사용하면 됨
    }
    avg() {
        return this.sum() / 3;
    }
};

var son = new PersonPlus('손흥민', 100,100,100);
console.log('손 sum : ', son.sum());
console.log('손 avg : ', son.avg());