Date.prototype.getIntervalDay = function(otherDay){
//     // now.getIntervalDay(limitDay) => now가 this, limitDay가 otherday
//     if(otherDay>this){
//         var IntervalMilliSec=otherDay.getTime()- this.getTime(); 
    
// }else{
//     var IntervalMilliSec = this.getTime()-otherDay.getTime();
//return Math.trunc(IntervalMilliSec/ (1000*60*60*24));
//}
var IntervalMilliSec = Math.abs(this.getTime()-otherDay.getTime());
return Math.trunc(IntervalMilliSec/ (1000*60*60*24));
}

var today = new Date();
var thatDay = new Date(2024,9,11,14,0,0);
console.log(today.getIntervalDay(thatDay));
console.log(thatDay.getIntervalDay(today));
