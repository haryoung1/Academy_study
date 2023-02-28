// var str = '안녕00방가00좋은아침00좋은하루'; // 00 > x로 교체
// console.log('원본 str : ' + str);
// var splitStr = str.split('00'); // ['안녕', '방가', '좋은아침', '좋은하루']
// console.log('분할된 str : ' + splitStr);
// var joinStr = splitStr.join('x');
// console.log('join 된 str : ' + joinStr);

function replaceAll(str, oldStr, newStr) {
    // 1. 매개변수 2. 원래스트링 3. 바꿀스트링
    // let splitStr = str.split(oldStr);
    // let result = splitStr.join(newStr);
    // return result;
    // 위에랑 밑에 이거랑 같은거임
    return str.split(oldStr).join(newStr); 
}

// 여기는 펑션 테스트
// var replaceStr = replaceAll('지금은00오후0017시00DK00VS00T100누가00이길까?', '00', ' ');
// console.log('테스트 결과 : ' + replaceStr);