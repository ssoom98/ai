
//2.js
// 다른 이름으로 저장(utf-8인 코드로 인코딩)
/* 동적인 부분(JaveScript)*/
        name = prompt("이름은 >", "홍길동"); // 취소를 클릭하면 'null'리턴
        if (name != 'null' && name != ""){
            document.write(name + "님 반갑습니다<br>");

        }