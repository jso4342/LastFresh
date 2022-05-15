function send(){
    $("#findId").css("display", "block");
}
function send1(){
    $("#findId1").css("display", "block");
}

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

