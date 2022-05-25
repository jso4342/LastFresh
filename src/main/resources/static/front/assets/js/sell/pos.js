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

/* 조리 시간 리셋*/
function resetCooking() {
    cookingTime = 0;
    $cookingTime.find('.cookingTime-real').text(cookingTime);
}
// $resetBtn.on("click", function () {
//     cookingTime = 0;
//     $cookingTime.find('.cookingTime-real').text(cookingTime);
// });

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

let pageNum = 1;
let amount = 4;
let billStatus = 0;

showList(pageNum, billStatus);

function showList(page, billStatus) {
    pageNum = page || 1;
    let amount = 4;
    let limit = (page - 1) * amount;
    console.log("들어옴1");

    $.ajax({
        type: "GET",
        url: "/pos/list/" + billStatus + "?pageNum=" + pageNum +
            "&amount=" + amount + "&limit=" + limit,
        success: function (result) {
            console.log("들어옴3");

            let str = "";
            let $orderList = $('.order-content');
            let $noorder = $('.noorder');

            // if(list == null || list.size == 0){
            //     $orderList.html("<p>주문이 없습니다.</p>");
            //     return;
            // }

            $.each(result.list, function (i, item) {
                str += '<div class="order-list-wrapper">';
                str += '<div class="order-list">';
                str += '<div class="order-info1">';
                str += '<div class="order-time">';
                str += item.billOrderDateTime;
                str += '</div>';
                if(item.billDeliveryMethod == 1) {
                    str += '<div class="order-method pickUp">';
                    str += '포장';
                }else if(item.billDeliveryMethod == 2) {
                    str += '<div class="order-method delivery">';
                    str += '배달';
                }else if(item.billDeliveryMethod == 3) {
                    str += '<div class="order-method shipping">';
                    str += '배송';
                }
                str += '</div>';
                str += '</div>';
                str += '<div class="order-info2">';
                str += '<div class="order-menu">';
                str += '<p class="order-price">' + item.billProductPrice.toLocaleString('ko-KR') + '원</p>';
                str += '<p class="order-menuInfo">' + item.sellProductName + ' ' + item.billProductQuantity + '개</p>';
                str += '</div>';
                str += '<br>';
                str += '<div class="order-address">';
                str += item.billDeliveryAddress + ' ' + item.billDeliveryAddressDetail;
                str += '</div>';
                str += '<div class="order-phoneNum">';
                str += item.userPhone;
                str += '</div>';
                str += '</div>';
                str += '<div class="order-accept">';
                str += '<button class="order-reception-btn"><a class="acceptOrder" href="' + item.billProductListNum + '">접수하기</a></button>';
                str += '<button class="order-cancel-btn"><a class="cancelOrder" href="' + item.billProductListNum + '">취소</a></button>';
                str += '</div>';
                str += '</div>';
                str += '<hr>';
                str += '</div>';
            });

            getCount(0);
            getCount(1);
            getCount(2);

            if(result.orderCount == 0) {
                str += '<img src="https://cdn.discordapp.com/attachments/969471931575320587/969481005150908456/7d8afc2c848b9d71.png">';
                str += '<p>즐거운 하루 보내세요!</p>'

                $noorder.html(str);
            }else {
                $orderList.html(str);

                showOrderPage(result.orderCount);
            }
        },
        error: function (error,status,msg) {
            alert("상태코드 " + status + "에러메시지" + msg)
        }
    });
}

function showOrderPage(orderCount) {
    let endNum = Math.ceil(pageNum / 10.0) * 10;
    let startNum = endNum - 9;
    let realEnd = Math.ceil(orderCount / 4.0);
    console.log("realEnd :" + realEnd);
    console.log("orderCount :" + orderCount);
    let str = "";

    const $pagingTag = $("div.paging");

    if(endNum > realEnd) {
        endNum = realEnd;
    }

    let prev = startNum > 1;
    let next = endNum * 4 < orderCount;

    if(prev){
        str += "<a class='changePage' href='" + (startNum - 1) + "'><code>&lt;</code></a>"
    }

    for(let i=startNum; i<=endNum; i++){
        if(pageNum == i){
            str += "<code class='selectedPage'>" + i + "</code>";
            continue;
        }
        str += "<a class='changePage' href='" + i + "'><code>" + i + "</code></a>";
    }

    if(next){
        str += "<a class='changePage' href='" + (endNum + 1) + "'><code>&gt;</code></a>"
    }

    $pagingTag.html(str);
}

/*페이지 이동*/
$(".paging").on("click", "a.changePage", function(e){
    e.preventDefault();
    pageNum = $(this).attr("href");
    showList(pageNum, billStatus);
});

//접수 창 열기
$(".order-content").on("click", "button.order-reception-btn", function(e){
    e.preventDefault();
    console.log("모달창");
    let billProductListNum = $(this).find('a').attr("href");

    $cookingModal.show();

    $('.billProductListNum').val(billProductListNum);

});

//접수 하기
$(".cookingTime-reception").on("click", function(e){

    let billProductListNum = $('.billProductListNum').val();

    let billCookingTime = $('.cookingTime-real').text();
    console.log(billProductListNum);
    console.log(billCookingTime);

    $.ajax({
        type: "PATCH",
        url: "/pos/accept/",
        data:JSON.stringify({"billProductListNum": billProductListNum, "billCookingTime": billCookingTime}),
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            swal(result);
            showList(pageNum, billStatus);
        },
        error: function (error,status,msg) {
            swal("상태코드 " + status + "에러메시지" + msg)
        }
    });

    resetCooking()
    $cookingModal.hide();
});

//취소 하기
$(".order-content").on("click", "button.order-cancel-btn", function(e){
    console.log("오더 캔슬 들어옴");
    e.preventDefault();
    let billProductListNum = $(this).find('a.cancelOrder').attr("href");

    console.log(billProductListNum);

    $.ajax({
        type: "PATCH",
        url: "/pos/cancel/",
        data:JSON.stringify({"billProductListNum": billProductListNum}),
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            swal(result);
            showList(pageNum, billStatus);
        },
        error: function (error,status,msg) {
            swal("상태코드 " + status + "에러메시지" + msg)
        }
    });
});

/*접수대기 클릭 시*/
function orderReady(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*접수대기 클릭 시*/
function orderProcessing(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*접수대기 클릭 시*/
function orderCompleted(num) {
    billStatus = num;
    pageNum = 1
    showList(pageNum, billStatus);
}

/*billStatus에 따른 총개수*/
function getCount(num) {
    $.ajax({
        type: "GET",
        url: "/pos/count/" + num,
        success: function (result) {
            console.log("num : 3번 나와야돼" + num)
            
            if(num == 0) {
                console.log("num = 0  : " + result);
                $('.preparedOrder').text(result);
                $('.reception-new').text("new");
            }

            if(result = 0) {
                $('.reception-new').text("");
            }

            if(num == 1) {
                console.log("num = 1  : " + result);
                $('.processingOrder').text(result);
            }

            if(num == 2) {
                console.log("num = 2  : " + result);
                $('.completedOrder').text(result);
            }
        },
        error: function (error,status,msg) {
            swal("상태코드 " + status + "에러메시지" + msg)
        }
    });
}


