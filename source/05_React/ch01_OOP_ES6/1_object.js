// 배열 복사
"use strict"; // 스트릭트 모드로 구현한다는 선언 (변수 선언 안하면 사용불가)
let memberArray = ['egoing', 'graphittie', 'leezhce'];
var copyArray = [ ...memberArray]; // 객체의 깊은 복사 [ ...]
var copyArray = Array.from(memberArray); // 배열의 깊은 복사


console.log(typeof(memberArray));
copyArray[0] = '홍길동'; copyArray[1] = '바꾸즈아'; copyArray[2] = '카피함';

console.group('memberArray for-loop');
for (var i=0 ; i<memberArray.length ; i++) {
    console.log(i + '번째 : ' , memberArray[i]);
}
console.groupEnd('memberArray for-loop');

console.group('copyArray for-loop');
copyArray.forEach(function(data,idx){
    console.log(idx, '번째 : ', copyArray[idx] );
});
console.groupEnd('copyArray for-loop');


// 객체 복사
var memberObject = {
    name : '강길동', 
    age  : 20,
};
// var copyObject = { ...memberObject}; // 객체의 깊은복사
var copyObject = Object.assign({},memberObject); // 객체의 깊은 복사 : 첫번째 : 빈스트링, 두번째 : 복사 할 객체를 적음
var copyObject = Object.assign({id:1}, memberObject); // 첫번째에 속성을 추가 할 수도 있음.

copyObject['name'] = '바꾼자';
console.group('memberObject for-in문');
for (var key in memberObject) {
    console.log(key, ' :', memberObject[key]);
}
console.groupEnd('memberObject for-in문');

console.group('copyObject for-in문');
for (var key in copyObject) {
    console.log(key, ' :', copyObject[key]);
}
console.groupEnd('copyObject for-in문');