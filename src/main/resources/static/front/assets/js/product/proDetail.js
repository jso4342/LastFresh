


var sell_price;
var amount;

function init () {
    sell_price = document.form.sell_price.value;
    amount = document.form.amount.value;
    $("input[name=sum]").val(sell_price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    //  document.form.sum.value = sell_price;

    change();
}

function add () {
    hm = document.form.amount;
    sum = document.form.sum;
    hm.value ++ ;
    $('#finalPrice').val(sum);
    $("input[name=sum]").val((parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    //  sum.value = (parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
    $('#finalPrice').val(parseInt(hm.value) * sell_price);

    doSum();

}

function del () {
    hm = document.form.amount;
    sum = document.form.sum;
    if (hm.value > 1) {
        hm.value -- ;
        $("input[name=sum]").val((parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        //    sum.value = (parseInt(hm.value) * sell_price).toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        $('#finalPrice').val(parseInt(hm.value) * sell_price);

        doSum();

    }
}

function change () {
    hm = document.form.amount;
    sum = document.form.sum;

    if (hm.value < 0) {
        hm.value = 0;
    }
}


var mySum = 0;
// 결제 금액
function doSum() {
    console.log("들어옴")
    $('input[name="sum"]').each(function () {
        console.log("val : " + $(this).text());
        mySum += parseInt($(this).val().replace(",", ""));

        console.log("sum : " + mySum);

    });

    /* $('#sumOrderProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#sumProduct').text(mySum.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
     $('#finalPrice').val(mySum);*/
    $('#che').val(mySum);
    //$('#finalPrice').value(sum);
    mySum = 0;
}

// 후기
const $btn = $(".tr_line");
const $groups = $(".review_view");
var check = false;
$.each($btn, function(index, item){
    $(item).click(function(){
        if(check == false){
            $($groups[index]).css("display", "block");
            check = true;

        }else{
            $($groups[index]).css("display", "none");
            check = false;
        };
    })
});

const $infomation = $("#infomation");
const $review = $("#review")
const $a1 = $("#infomation_a");
const $a2 = $("#review_a");

console.log($a1);
console.log($a2);
$infomation.click(function (){
    $a1.addClass("__active");
    $a2.removeClass("__active");
})
$review.click(function (){
    $a2.addClass("__active");
    $a1.removeClass("__active");
})