const person ={'name': '홍길동','age':22}; //오브젝트
console.log('name:', person.name,', age :' + person.age);
person.name = '신길동';
console.log('name:', person.name,', age :' + person.age);
const arr = ['김길동',22];
arr[0]='신길동';
console.log(arr[0], arr[1])