//class : ECMA script 6
//caniuse.com를 이용해서 지원 브라우저를 확인
class Person{
    constructor(name, first, second){ // 생성자 함수 이름은 무조건 constructor
        console.log('생성자 함수 호출');
        this.name=name;
        this.first=first;
        this.second=second; // 컨스트럭터 안에 함수 X

    }
    sum(){
        return this.first + this.second;
    }//sum
}//class
var hong = new Person('홍길동',90,97);
    console.log(hong.name,',',hong.first,',',hong.second);
    console.log('합계 : ' + hong.sum());
    