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





// 5f4d1ae11a3b60e8962da349854f336d
// window.Kakao.auth.login({
//     scope: 'profile, account_email, gender',
//     success: function (authObj) {
//         console.log(authObj);
//         window.Kakao.API.request({
//             url: 'v2/user.me',
//             success: res => {
//                 const kakao_account = res.kakao_account;
//                 console.log(kakao_account);
//             }
//         })
//
//     }
// });


