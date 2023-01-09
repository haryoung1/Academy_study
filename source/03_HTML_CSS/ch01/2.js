// 2.js : 동적인 부분
name = prompt("what's your name?", "Hong"); // 취소를 클릭하면 'null' 리턴
if (name != 'null' && name != '') {
    document.write(name + "~ Welcom<br>");
}