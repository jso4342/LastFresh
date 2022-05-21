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
let button = $(".half");
$(".innerLatChanceCart").click(function () {
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(".innerCart").click(function () {
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
    $("#cartPut").css("display", "block");
});

$(button).click(function () {
    $(cart).addClass("off");
    $(cart).css("opacity", "0");
    $(".bg_loading").css("display", "none");
    $(".result").val(1);
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "#8BC34A")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "#03A9F4")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "#FFC107")
    $("#receiveMethodHidden").val(0)
});

//마감날짜
let today = new Date();
let year = today.getFullYear(); // 년도
let month = today.getMonth() + 1;  // 월
let date = today.getDate();  // 날짜
let calender = "&nbsp;" + "&nbsp;" + "~" + year + "/" + month + "/" + date
document.getElementById("lastChanceDate").innerHTML = calender
console.log("calender", calender)

//장바구니 가격 표시
function  AddComma(num)
{
    let regexp = /\B(?=(\d{3})+(?!\d))/g;
    return num.toString().replace(regexp, ',');
}

$(document).ready(function () {
    $(".result").val(1);
});

$(".toBasket").each(function (i, item) {
    let price = AddComma($(".newPrice")[i].innerHTML);
    let beforePrice = ($(".dcPriceNum")[i].innerHTML);
    let beforePriceWithCom =AddComma ($(".dcPriceNum")[i].innerHTML);
    let productName = ($(".productName")[i].innerHTML);
    let pno = ($(".pno")[i].innerHTML);
    $(this).click(function () {
        //상품명
        $(".name").html(productName);
        //상품 번호
        $(".pnoHidden").val(pno);
        //일반 금액
        $(".dc_price").html(price);
        $(".fixedHiddenNum").val(beforePrice);
        //합계 전 가격
        $(".num").html(beforePriceWithCom);
        $(".totalMoneyHidden").val(beforePrice);

    })
});

// 더하기/빼기
function count(type) {
    // 더하기/빼기
    let afterPrice = $(".num");
    let resultElement = $(".result");
    let number = resultElement.val();
    let hiddenAfPrice = $(".totalMoneyHidden");
    let hiddenTotalPrice = parseInt($(".totalMoneyHidden").val());
    let fixedHiddenNum = parseInt($(".fixedHiddenNum").val());
    let total;
    if (type === 'plus') {
        number = parseInt(number) + 1;
        total = hiddenTotalPrice + fixedHiddenNum;
    } else if (type === 'minus') {
        number = parseInt(number) - 1;
        total = hiddenTotalPrice - fixedHiddenNum;
        console.log(total)
        if (number == 0) {
            return
        }
    }
    resultElement.val(number);
    hiddenAfPrice.val(total);
    afterPrice.html(AddComma(total));

}

// 전달방식
document.getElementById("pickUpB").addEventListener("click", function () {
    $("#pickUpB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "#03A9F4")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "#FFC107")
    $(".receiveMethodHidden").val(1)
   
})
document.getElementById("deliveryB").addEventListener("click", function () {
    $("#deliveryB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "#8BC34A")
    $("#shippingB").css("opacity", "0.2").css("border", "none").css("background-color", "#FFC107")
    $(".receiveMethodHidden").val(2)
   
})
document.getElementById("shippingB").addEventListener("click", function () {
    $("#shippingB").css("opacity", "1").css("border", "2px solid  #DA291C").css("background-color", "#DA291C")
    $("#pickUpB").css("opacity", "0.2").css("border", "none").css("background-color", "#8BC34A")
    $("#deliveryB").css("opacity", "0.2").css("border", "none").css("background-color", "#03A9F4")
    $(".receiveMethodHidden").val(3)

})
