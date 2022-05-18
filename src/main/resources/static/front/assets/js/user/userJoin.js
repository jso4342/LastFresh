var check = false;
var check2 = false;

//a태그 링크 없애기
$("#addressButton").removeAttr("href")
$("#phoneCheckButton").removeAttr("href")


//휴대폰인증
$('#phoneCheckButton').click(function(){
    let userPhone = $('#userPhone').val();
    Swal.fire('인증번호 발송 완료!')


    $.ajax({
        type: "GET",
        url: "/user/manage/phoneCheck",
        data: {
            "userPhone" : userPhone
        },
        success: function(res){
            $('#phoneCheck').click(function(){
                if($.trim(res) ==$('#checkCN').val()){
                    Swal.fire(
                        '인증성공!',
                        '휴대폰 인증이 정상적으로 완료되었습니다.',
                        'success'
                    )
                    $('#phoneCheck').css('display','none');
                    $('#phoneCheckButton').css('display','none');

                    $.ajax({
                        type: "GET",
                        url: "/update/phone",
                        data: {
                            "userPhone" : $('#userPhone').val()
                        }
                    })
                    //document.location.href="/user/manage/userJoin";
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: '인증오류',
                        text: '인증번호가 올바르지 않습니다!',
                        footer: '<a href="/user/manage/userJoin">다음에 인증하기</a>'
                    });

                }

            })

        }
    })
});



// 주소 찾기(Daum API)
function find() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('userAddressPostNum').value = data.zonecode;
            document.getElementById("userAddress").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("userAddressDetail").focus();
        }
    }).open();
}

// const modal = document.querySelector('.modal');
// const btnOpenPopup = document.querySelector('.link_btn_agree');
// btnOpenPopup.addEventListener('click', () => {
//     modal.style.display = 'block';
// });
// modal.addEventListener('click', ()=>{
//     modal.style.display='none';
// });
/*상혁씨 코드*/

//모달창
$('.link_btn_agree').each(function (i,btn) {
    $(btn).on("click",function () {
        $($(".modal").get(i)).show();
    })
})

$('.btn_ok').each(function (i,ok) {
    $(ok).on("click",function () {
        $($(".modal").get(i)).hide();
    })
})

$('.modal').each(function (i,modal) {
    $(modal).on("click",function () {
        $(this).hide();
        // $($(".modal").get(i)).hide();
    })
})


//체크박스
const $all = $("#check1");
const $all2 = $("#check2");

$(document).ready(function() {
    $(".link_btn_agree").each(function(i, item){
        $(this).on("click", function(e){
            e.preventDefault();
            $($(".modal")[i]).show();
        })
    });
    $("#allCheck").click(function() {
        if($("#allCheck").is(":checked")) $("input[name=check]").prop("checked", true);
        else $("input[name=check]").prop("checked", false);
    });

    $("input[name=check]").click(function() {
        var total = $("input[name=check]").length;
        var checked = $("input[name=check]:checked").length;

        if(total != checked) $("#allCheck").prop("checked", false);
        else $("#allCheck").prop("checked", true);
    });
});


// 비밀번호 확인
 function match(obj) {
    let userPw = document.querySelector('#userPw').value;
    let userPwOk = document.querySelector('#userPwOk').value;
    let resultPw = document.getElementById('resultPw');

        if(userPw != userPwOk){
            resultPw.innerText = '비밀번호가 일치하지 않습니다.';
            resultPw.style.color = 'red';
            obj.value ='';
            obj.focus();
            return false;
        }else {
            resultPw.innerText = '비밀번호가 일치합니다.';
            resultPw.style.color = 'blue';
        }
    }


//아이디 중복검사
function checkId(userId){
    if(!userId){
        $("#result").text("아이디를 입력해주세요.");
        $("#result").css("color", "red");
        return;
    }

    $.ajax({
        url: "/user/manage/IDCheck/" + userId,
        type: "get",
        dataType: "json",
        success: function(result){
            if(result.status == "ok"){
                $("#result").text("사용한 가능한 아이디입니다.");
                $("#result").css("color", "blue");
                check = true;
            }else{
                $("#result").text("중복된 아이디입니다.");
                $("#result").css("color", "red");
                $("input#userId").focus();
            }
        },
        error: function(){
            console.log("중복검사 오류");
        }
    });
}

//아이디 중복 키 이벤트
$("a.btn_check").on("click", function(e){
    e.preventDefault();
    check = false;
    checkId($("input#userId").val());
});





//이메일 중복 키 이벤트
$("a.btn_check2").on("click", function(e){
    e.preventDefault();

    check = false;
    checkEmail($("input#userEmail").val());
});

//이메일 중복검사
function checkEmail(userEmail){
    if(!userEmail){
        $("#resultEmail").text("아이디를 입력해주세요.");
        $("#resultEmail").css("color", "red");
        return;
    }

    $.ajax({
        url: "/user/manage/EmailCheck/" + userEmail,
        type: "get",
        dataType: "json",
        success: function(resultEmail){
            if(resultEmail.status == "ok"){
                $("#resultEmail").text("사용한 가능한 이메일입니다.");
                $("#resultEmail").css("color", "blue");
                check2 = true;
            }else{
                $("#resultEmail").text("중복된 이메일입니다.");
                $("#resultEmail").css("color", "red");
                $("input#userEmail").focus();
            }
        },
        error: function(){
            console.log("중복검사 오류");
        }
    });
}

// //비밀번호 유효성검사
// function checkPw() {
//     let id = $("#id").val();
//     let pw = $("#password").val();
//     let number = pw.search(/[0-9]/g);
//     let english = pw.search(/[a-z]/ig);
//     let spece = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);
//     let reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
//
//     if (pw.length < 8 || pw.length > 20) {
//         alert("8자리 ~ 20자리 이내로 입력해주세요.");
//         return false;
//
//     } else if (pw.search(/\s/) != -1) {
//         alert("비밀번호는 공백 없이 입력해주세요.");
//         return false;
//
//     } else if (number < 0 || english < 0 || spece < 0) {
//         alert("영문,숫자,특수문자를 혼합하여 입력해주세요.");
//         return false;
//
//     } else if ((number < 0 && english < 0) || (english < 0 && spece < 0) || (spece < 0 && number < 0)) {
//         alert("영문,숫자, 특수문자 중 2가지 이상을 혼합하여 입력해주세요.");
//         return false;
//
//     } else if (/(\w)\1\1\1/.test(pw)) {
//         alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
//         return false;
//
//     } else if (pw.search(id) > -1) {
//         alert("비밀번호에 아이디가 포함되었습니다.");
//         return false;
//     } else {
//         alert("비밀번호가 정상적으로 입력되었습니다.");
//         return true;
//     }
//
//     if (false === reg.test(pw)) {
//         alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
//         return false;
//     } else {
//         alert("비밀번호가 정상적으로 입력되었습니다.");
//         return true;
//     }
//
// }


//유효성 검사
function sendJoin() {

     if(!$all.is(":checked")){
        alert("약관에 동의해주세요.");
        return;
    }
     if(!$all2.is(":checked")){
        alert("약관에 동의해주세요.");
        return;
    }
    if(!check){
        alert("아이디를 확인해주세요.");
        return;
    }

    if(!joinForm.userPw.value){
        alert("패스워드를 확인해주세요.");
        return;
    }
    if(!joinForm.userPwOk.value){
        alert("패스워드 확인란을 확인해주세요.");
        return;
    }
    if(joinForm.userPw.value != joinForm.userPwOk.value) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }
    if(!joinForm.userName.value){
        alert("이름을 확인해주세요.");
        return;
    }
    if(!check2){
        alert("이메일을 확인해주세요.");
        return;
    }
    if(!joinForm.userPhone.value){
        alert("핸드폰 번호를 입력해주세요.");
        return;
    }
    if(!joinForm.userAddressPostNum.value){
        alert("우편번호를 입력해주세요.");
        return;
    }
    if(!joinForm.userAddress.value){
        alert("주소를 입력해주세요.");
        return;
    }
    if(!joinForm.userAddressDetail.value){
        alert("상세주소를 입력해주세요.");
        return;
    }
    // if($('#phoneCheck')==a){
    //     alert("휴대폰 인증을 진행해 주세요");
    //     return;
    // }
    joinForm.submit();
}