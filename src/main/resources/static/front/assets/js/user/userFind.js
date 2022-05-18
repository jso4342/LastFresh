
function showemaildiv() {
    $('.email_box').show();
    $('.email_verification').css("color","#da291c");
    $('.phone_box').hide();
    $('.hp_verification').css("color","#333");
    $('.hp_verification').css("box-shadow","none");
    $('.email_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");
    $("#el059co4").css("display", "none");
    $(".check").css("display", "none");
    $(".check1").css("display", "none");
    $("#emailCheck").css("display", "block");
    $("#findId1").css("display", "none");
    $("#findId").css("display", "none");
}

function showphonediv() {
    $('.phone_box').show();
    $('.email_verification').css("color","#333");
    $('.email_box').hide();
    $('.hp_verification').css("color","#DA291C");
    $('.email_verification').css("box-shadow","none");
    $('.hp_verification').css("box-shadow","inset 0px -2px 0px 0px #DA291C");
    $("#el059co3").css("display", "none");
    $(".check1").css("display", "none");
    $("#phoneCheck").css("display", "block");
    $("#findId1").css("display", "none");
    $("#findId").css("display", "none");
}

$( document ).ready(function() {
    $('.email_box').hide();
    // $("button").click(function(){
    // });
});

function find(){
    $(".authentication_number").css("display", "flex");
    $("#el059co3").css("display", "block");
    $("#emailCheck").css("display", "none");
    $(".check1").css("display", "block");
}
function find1(){
    $(".authentication_number").css("display", "flex");
    $("#el059co4").css("display", "block");
    $("#phoneCheck").css("display", "none");
    $(".check").css("display", "block");
}

/*  cool sns 문자인증*/
$('#phoneCheck').click(function(){
    let phoneNumber = $('#phone').val();
    Swal.fire('인증번호 발송 완료!')


    $.ajax({
        type: "GET",
        url: "/find/check/sendSMS",
        data: {
            "phoneNumber" : phoneNumber
        },
        success: function(res){
            $('#check').click(function(){
                if($.trim(res) ==$('#inputCertifiedPhone').val()){

                    $(cart1).removeClass("off");
                    $(cart1).css("opacity", "1");
                    $(".bg_loading").css("display", "block");
                   /* location.href = "/user/manage/userId"*/
                    $.ajax({
                        type: "GET",
                        url: "/find/phoneNumber",
                        data: {
                            "userPhone" : $('#phone').val()
                        },
                        success: function(data){
                            $('#findId_css').text(data);
                        }

                    })
                }else{
                    Swal.fire({
                        icon: 'error',
                        title: '인증오류',
                        text: '인증번호가 올바르지 않습니다!',
                        footer: '<a href="/main/main">다음에 인증하기</a>'
                    })
                }
            })


        }
    })
});

var cart = $(".cart_option");
var cart1 = $(".cart_option1");

var button = $(".cancel");
var button1 = $(".cancel1");

/*$(".check").click(function(){
    $(cart1).removeClass("off");
    $(cart1).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});*/

