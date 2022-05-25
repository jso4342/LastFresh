//로그인
function sendLogin(){
        if(!loginForm.userId.value){
            alert("아이디를 확인해주세요");
            return;
        }
        if(!loginForm.userPw.value){
            alert("패스워드를 확인해주세요");
            return;
        }
    loginForm.submit();

}


