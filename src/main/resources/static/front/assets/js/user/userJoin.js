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

                    $.ajax({
                        type: "GET",
                        url: "/update/phone",
                        data: {
                            "userPhone" : $('#userPhone').val()
                        }
                    })
                    document.location.href="/user/manage/userJoin";
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: '인증오류',
                        text: '인증번호가 올바르지 않습니다!',
                        footer: '<a href="/user/manage/userJoin">다음에 인증하기</a>'
                    })
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



function sendJoin() {
    joinForm.submit();
}