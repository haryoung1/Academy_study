// 단순객체 생성 사용하기 불편

let kim = {
    name : 'kim',
    first : 10,
    second : 20,
    sum : function() {
        return this.first + this.second;
    },
};
let lee = {
    name : 'lee',
    first : 30,
    second : 20,
    sum : function() {
        return this.first + this.second;
    },
};
console.log(kim.name,':', kim.first,',', kim.second, ',', kim.sum());
console.log(lee.name,':', lee.first,',', lee.second, ',', lee.sum());