let $menuItemlist = $($(".menuItem.list"));
let $menuItemmyList = $($(".menuItem.myList"));
let $deliveryList = $($(".deliveryList.sideItem"));
let $myDeliveryList = $($(".myDeliveryList.sideItem"));

$menuItemlist.on("click", function () {
    $menuItemmyList.css("background", "#d9d9d9").css("color", "#818181cc");
    $menuItemlist.css("background", "white").css("color", "#2C2929");
})

$menuItemmyList.on("click", function () {
    $menuItemlist.css("background", "#d9d9d9").css("color", "#818181cc");
    $menuItemmyList.css("background", "white").css("color", "#2C2929");
})
$deliveryList.on("click", function () {
    $myDeliveryList.css("background", "#d9d9d9").css("color", "#818181cc");
    $deliveryList.css("background", "white").css("color", "#2C2929");
})

$myDeliveryList.on("click", function () {
    $deliveryList.css("background", "#d9d9d9").css("color", "#818181cc");
    $myDeliveryList.css("background", "white").css("color", "#2C2929");
})

/* 동필터링 */
var cart1 = $(".cart_option1");
var button1 = $(".cancel1");

$(".areabutton").click(function () {
    $(cart1).removeClass("off");
    $(cart1).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});

$(button1).click(function () {
    $(cart1).addClass("off");
    $(cart1).css("opacity", "0");
    $(".bg_loading").css("display", "none");
});

/* 주소 */
var width = 500; //팝업의 너비
var height = 600; //팝업의 높이

// 주소 찾기(Daum API)
function find() {
    new daum.Postcode({
        width: width, //생성자에 크기 값을 명시적으로 지정
        height: height,

        oncomplete: function (data) {
            var addr = ''; // 주소 변수
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('zipcode').value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("addressDetail").focus();
        }
    }).open({
        left: (window.screen.width / 2) - (width / 2),
        top: (window.screen.height / 2) - (height / 2)
    });

}

$(document).ready(function () {
    //sido option 추가
    $.each(hangjungdong.sido, function (idx, code) {
        //append를 이용하여 option 하위에 붙여넣음
        $('#sido').append(fn_option(code.sido, code.codeNm));
    });

    //sido 변경시 시군구 option 추가
    $('#sido').change(function () {
        $('#sigugun').show();
        $('#sigugun').empty();
        $('#sigugun').append(fn_option('', '선택')); //
        $.each(hangjungdong.sigugun, function (idx, code) {
            if ($('#sido > option:selected').val() == code.sido)
                $('#sigugun').append(fn_option(code.sigugun, code.codeNm));
        });

        //세종특별자치시 예외처리
        //옵션값을 읽어 비교
        if ($('#sido option:selected').val() == '36') {
            $('#sigugun').hide();
            //index를 이용해서 selected 속성(attr)추가
            //기본 선택 옵션이 최상위로 index 0을 가짐
            $('#sigugun option:eq(1)').attr('selected', 'selected');
            //trigger를 이용해 change 실행
            $('#sigugun').trigger('change');
        }
    });

    //시군구 변경시 행정동 옵션추가
    $('#sigugun').change(function () {
        //option 제거
        $('#dong').empty();
        $.each(hangjungdong.dong, function (idx, code) {
            if ($('#sido > option:selected').val() == code.sido && $('#sigugun > option:selected').val() == code.sigugun)
                $('#dong').append(fn_option(code.dong, code.codeNm));
        });
        //option의 맨앞에 추가
        $('#dong').prepend(fn_option('', '선택'));
        //option중 선택을 기본으로 선택
        $('#dong option:eq("")').attr('selected', 'selected');

    });

    $('#dong').change(function () {
        var sido = $('#sido option:selected').val();
        var sigugun = $('#sigugun option:selected').val();
        var dong = $('#dong option:selected').val();
        var dongCode = sido + sigugun + dong + '00';
    });
});


function fn_option(code, name) {
    return '<option value="' + code + '">' + name + '</option>';
}

function filter() {
    let sidoIdx=hangjungdong.sido.findIndex(i=>i.sido==$("#sido").val());
    let sigugunIdx=hangjungdong.sigugun.findIndex(i=>i.sigugun==$("#sigugun").val()&&i.sido==$("#sido").val());
    let dongIdx=hangjungdong.dong.findIndex(i=>i.dong==$("#dong").val()&&i.sigugun==$("#sigugun").val()&&i.sido==$("#sido").val());

    let sido = hangjungdong.sido[sidoIdx].codeNm;//시
    let sigungu = hangjungdong.sigugun[sigugunIdx].codeNm;//시군구
    let dong = hangjungdong.dong[dongIdx].codeNm;//동

    window.location.href = "/rider/riderListF?sido=" + sido+"&sigungu=" + sigungu +"&dong=" + dong;

}
/*1픽업 2배달 3배송*/
$(".order-info1").each(function (i, item) {
    let num = $(this).children(".noEx").text();

    if (num == 2) {
        $(this).children(".delivery").css("display", "block");
    }
    if (num == 3) {
        $(this).children(".shipping").css("display", "block");
    }
})

$(".areabutton").click(function (i, item) {
    $(".cart_option1").show();
})
$("button.base_button1").click(function (i, item) {
    $(".cart_option1").hide();
})

$(".order-list-wrapper").each(function () {
    let OrderDateTime = $(this).find("#billOrderDateTime").val();
    let billCookingTime = $(this).find("#billCookingTime").val();

    let date = new Date(OrderDateTime);
    date.setMinutes(date.getMinutes() + billCookingTime);
    let time = ((date.getMonth()+1) +"월"+ " " + date.getDate() +"일"+ "  " + date.getHours() + ":" + date.getMinutes());

    $(this).find("#order-time").html(time);

    console.log($("#order-time").html());
})

//
// //my 목록
// function getMyList() {
//     $.ajax({
//         type: "get",
//         url: "/rider/riderMy",
//         data: "data",
//         success: showMyList
//         , error: function (a, b, c) {
//             console.log("오류" + c);
//         }
//     });
// };
//
// function showMyList(orders) {
//     let text = "";
//     if (orders != null && orders.length != 0) {
//         $.each(orders, function (index, info) {
//             <!-- 접수 대기 목록이 있을 시-->
//     text+='    <div class="order-content" >'
//     text+='            <div class="order-list-wrapper">'
//     text+='            <hr>'
//     text+='            <div class="order-list myDeliveryInfo">'
//     text+='            <!-- 시간&수령 방법-->'
//     text+='        <div class="orderWrap">'
//     text+='            <div class="order-timeTit">'
//     text+='            조리시간'
//     text+='            </div>'
//     text+='            <div class="order-info1">'
//     text+='            <div class="order-time">'
//     text+='            18:41'
//     text+='        </div>'
//     text+='        <div class="order-method shipping">'
//     text+='            배송'
//     text+='            </div>'
//     text+='            </div>'
//     text+='            </div>'
//     text+='            <!-- 주문 관련 정보 (가격, 메뉴이름, 수량, 주소)-->'
//     text+='            <div class="order-info2">'
//     text+='            <div class="order-menu">'
//     text+='            <p class="order-menuInfo">엄~청 맛있는 김치찌개 2개</p>'
//     text+='        <p class="storeName">코리아김치: 010-1234-1234</p>'
//     text+='        </div>'
//     text+='        <br>'
//     text+='        <div class="addressWrap">'
//     text+='            <div class="order-address">'
//     text+='            <div class="addressTitle">출발지:</div>'
//     text+='        <div class="address">배민동 배민 아파트 2동 101호</div>'
//     text+='        </div>'
//     text+='        <div class="order-address">'
//     text+='            <div class="addressTitle">도착지:</div>'
//     text+='        <div class="address">서울 송파구 방이동 999-9</div>'
//     text+='        </div>'
//     text+='        </div>'
//     text+='        </div>'
//     text+='        <!--  주문 수락 및 취소-->'
//     text+='        <div class="btnWrap">'
//     text+='            <div class="order-accept myDeliveryBtn">'
//     text+='            <input type="button" class="deliveryFinishBtn pc" value="전달완료">'
//     text+='            <input type="button" class="deliveryFinish" value="완료">'
//     text+='            <input type="button" class="deliveryCancel" value="접수취소">'
//     text+='            <a href="tel:01012341234">'
//     text+='            <div class="callIconWrap">'
//     text+='            <input type="button">'
//     text+='            <div class="callIcon">'
//     text+='            <img class="callImg" src="https://cdn.discordapp.com/attachments/969471931575320587/970637419240108072/4141.png">'
//     text+='            </div>'
//     text+='            </div>'
//     text+='            </a>'
//     text+='            </div>'
//     text+='            <input type="button" class="deliveryFinishBtn Mobile" value="전달완료">'
//     text+='            </div>'
//     text+='            </div>'
//     text+='            <hr>'
//     text+='            </div>'
//
//         });
//     } else {
//         text +='<div class="noorder">'
//         text +='    <img src="https://cdn.discordapp.com/attachments/969471931575320587/969481005150908456/7d8afc2c848b9d71.png">'
//         text +='    <p>즐거운 하루 보내세요!</p>'
//         text +='</div>'
//     }
//     $(".sidebar-content").html(text);
// }

