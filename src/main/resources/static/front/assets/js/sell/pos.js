/* 조리 시간 닫기 버튼*/
let $closeBtn = $('.cookingTime-close-btn');

/* 조리 시간 모달창*/
let $cookingModal = $('.cookingTime-wrapper');

/* 조리 시간*/
let $cookingTime = $('.cookingTime-real-wrapper');

/* 접수 버튼*/
let $receptionBtn = $('.order-reception-btn');

/* 조리 시간 리셋 버튼*/
let $resetBtn = $('.cookingTime-reset');

/* 조리 시간 플러스 버튼*/
let $plusBtn = $('.cookingTime-plus');

/* 조리 시간 마이너스 버튼*/
let $minusBtn = $('.cookingTime-minus');

/* 조리 시간 리얼 타임*/
let cookingTime = 0;

/* 사이드바 메뉴들*/
let $sideBars = $('.sideBars');


/* 조리 시간 닫기*/
$closeBtn.on("click", function () {
    $cookingModal.hide();
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 열기*/
$receptionBtn.on("click", function () {
    $cookingModal.show();
});

/* 조리 시간 리셋*/
$resetBtn.on("click", function () {
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 늘리기*/
$plusBtn.on("click", function () {
    cookingTime += 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

/* 조리 시간 줄이기*/
$minusBtn.on("click", function () {
    if(cookingTime == 0){return;}
    cookingTime -= 10;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
});

$.each($sideBars, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $sideBars.length; j++){
            $sideBars[j].classList.remove("sellClicked")
        }

        $sideBars[index].classList.add("sellClicked");
    });
});

let page = 1;
let amount = 4;
let billStatus = 0;

listAjax(page, amount, billStatus);

function listAjax(page, amount, billStatus) {
    let pageNum = page || 1;
    let limit = (page - 1) * amount;
    console.log("들어옴1");

    $.ajax({
        type: "GET",
        url: "/pos/list/" + billStatus + "/" + pageNum + "/" + amount + "/" + limit,
        success: function (list) {
            console.log("들어옴3");

            let str = "";
            let $orderList = $('.order-content');

            if(list == null || list.length == 0){
                $orderList.html("<p>주문이 없습니다.</p>");
                return;
            }

            str += '<div class="order-list-wrapper">';
            str += '<div class="order-list">';
            str += '<div class="order-info1">';
            str += '<div class="order-time">';
            str += '18:41';
            str += '</div>';
            str += '<div class="order-method pickUp">';
            str += '포장';
            str += '</div>';
            str += '</div>';
            str += '<div class="order-info2">';
            str += '<div class="order-menu">';
            str += '<p class="order-price">31,800원</p>';
            str += '<p class="order-menuInfo">김치찌개 2개</p>';
            str += '</div>';
            str += '<br>';
            str += '<div class="order-address">';
            str += '서울 송파구 방이동 999-9';
            str += '</div>';
            str += '<div class="order-phoneNum">';
            str += '010-5999-9999';
            str += '</div>';
            str += '</div>';
            str += '<div class="order-accept">';
            str += '<button class="order-reception-btn">접수하기</button>';
            str += '<button class="order-cancel-btn">취소</button>';
            str += '</div>';
            str += '</div>';
            str += '<hr>';
            str += '</div>';

            $orderList.html(str);
        },
        error: function (error,status,msg) {
            alert("상태코드 " + status + "에러메시지" + msg)
        }
    });
}