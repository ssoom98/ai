function sumAll(){
    let result = 0;
    if(arguments.length==0){
        
       return -999;

    }else if(arguments.length>=1){
        for(let idx=0; idx<arguments.length; idx++){
           result += arguments[idx];
        }
    }
    return result;
}
console.log(sumAll(3,4, 10));