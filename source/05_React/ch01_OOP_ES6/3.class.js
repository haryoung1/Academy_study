// class ECMA script 6이상을 지원하는 브라우저만 가능 
// https://caniuse.com : 지원되는 브라우저 확인 (웬만하면 다 됨 익스플로러 제외)
class Person {
// 모든 클래스의 생성자함수 이름은 constructor로 해야함
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
}; // class

var kim = new Person('kim', 10, 20);
kim.sum = function() {
    return '수정 된 kim의 sum : ' + (this.first+this.second); // 상속 받지 않고 바로 수정이나 추가 가능하다.
};
var lee = new Person('lee', 30, 40);

console.log(kim.name,':', kim.first,',', kim.second, ',', kim.sum());
console.log(lee.name,':', lee.first,',', lee.second, ',', lee.sum());