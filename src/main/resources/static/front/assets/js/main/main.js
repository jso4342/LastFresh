/*
var check = false;

const $category = $('.gnb_menu li');


function send(){
    if(check == false) {
        $('.gnb_sub').show();
        /!*	$('#allCategory').css({
                "color" : "#DA291C",
                "font-weight" : "600"
            });*!/
        check = true;
    }else {
        $('.gnb_sub').hide();
        /!*$('#allCategory').css({
            "color" : "#333",
            "font-weight" : "500"
        });*!/
        check = false;
    }
}

$.each($category, function(index, item){
    $(item).mouseover(function(){
        $category.addClass("current");
    })
});
*/



let cart = $(".cart_option");
let button = $(".cancel");
$(".innerLatChanceCart").click(function(){
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(".innerCart").click(function(){
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(button).click(function(){
    $(cart).addClass("off");
    $(cart).css("opacity", "0");
    $(".bg_loading").css("display", "none");
});
$(document).ready( function() {
    $(".result").val(1);
});
let total=0;

// function count(type)  {
//     // 결과를 표시할 element
//     let resultElement = $(".result");
//     let afterPrice =$(".num");
//     // 현재 화면에 표시된 값
//     // let number = resultElement.val();
//     // let beforePrice =($(".dcPriceNum").innerHTML);
//     console.log(total)
//     // 더하기/빼기
//     $(".toBasket").each(function(i, item) {
//         //일반금액
//         let price=($(".newPrice")[i].innerHTML);
//         $(".dc_price").html(price);
//         //합계 전 가격
//         let beforePrice =($(".dcPriceNum")[i].innerHTML);
//         $(".num").html(beforePrice);
//         console.log(beforePrice)
//         //수량
//         let number = resultElement.val();
//
//         if (type === 'plus') {
//             number = parseInt(number) + 1;
//             console.log(number)
//             total = beforePrice * number;
//             console.log(total)
//         } else if (type === 'minus') {
//             number = parseInt(number) - 1;
//             total = (beforePrice / number);
//             console.log(total)
//             if (number == 0) {
//                 return
//             }
//         }
//         resultElement.val(number);
//         afterPrice.html(total);
//     });
//
//     // 내용 포멧
//
//     // 결과 출력
// }
