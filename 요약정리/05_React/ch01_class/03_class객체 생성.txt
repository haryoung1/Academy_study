// class를 이용한 객체 생성
// class ECMA script 6이상을 지원하는 브라우저만 가능 
// 모든 클래스의 생성자함수 이름은 constructor로 해야함 ★

class Person {
    constructor(name, first, second) { // 얘가 생성자 함수
        console.log('생성자 함수 호출');
        // this 넣어야 생성자 함수안에 있는 데이터 사용가능
        this.name = name;
        this.first = first;
        this.second = second;
    };
    // 클래스 안에서의 function은 펑션빼고 넣음됨 
    sum() {
        return this.first + this.second;
    };
};

var kim = new Person('kim', 10, 20);

// 상속 받지 않고 바로 수정이나 추가 가능하다.

kim.sum = function() {
    return '수정 된 kim의 sum : ' + (this.first+this.second);};

console.log(kim.name,':', kim.first,',', kim.second, ',', kim.sum());
