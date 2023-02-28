function sumAll() {
    var result = 0;
    if (arguments.length == 0) {
        result = -999;
    }else if(arguments.length >= 1) {
        for (var idx=0; idx<arguments.length; idx++) {
            result += arguments[idx];
        }
    }
    return result;
}
// console.log(sumAll());
// console.log(sumAll(3));
// console.log(sumAll(1,2,3,4));
// console.log(sumAll(1,2,3,10,100));