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
    doTotal();
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
        doTotal();
    }
}

function change () {
    hm = document.form.amount;
    sum = document.form.sum;

    if (hm.value < 0) {
        hm.value = 0;
    }
}

function selectAll(selectAll)  {
    const checkboxes
        = document.getElementsByName('product');

    checkboxes.forEach((checkbox) => {
        checkbox.checked = selectAll.checked;
    })
    $('#howManyChecks').text($("input:checkbox[name=product]:checked").length);
    doTotal();
}


$('input[name="product"]').change(function()
{
    if($("input:checkbox[name=product]:checked").length == document.getElementsByName('product').length){
        $("#allCheck").prop('checked', true);

    }else{
        $("#allCheck").prop('checked', false);
    }
    $('#howManyChecks').text($("input:checkbox[name=product]:checked").length);
    doTotal();
});


var mySum = 0;
// 결제 금액
function doSum() {

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


function doTotal() {
    var total = 0;
    var count = document.getElementsByClassName('prod').length;
    for (var i = 0; i < count; i++) {
        if ($(".chekbox")[i].checked == true) {
            total += parseInt($(".chekbox")[i].value);
        }
    }
    //  console.log(total);

    $('#sumOrderProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $('#sumProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    $('#finalPrice').val(total);

    total = 0;
}

/*

    var total = 0;
    function doTotal(){
        //console.log($("input:checkbox[name=product]:checked").length);
        $(".prod").each(function () {
            if( $(this).find('input:checkbox[name=product]:checked')){

                console.log("here" + $(this).find('input[name="sum"]').val());
            }else{
                console.log("no");
            }

        });
*/


/*
        $("input:checkbox[name=product]:checked").each(function () {
            console.log($(this).find('input[name="sum"]').val());
            console.log("here : " + $(this).find('input[name="sum"]').val());

            total += parseInt($(this).find('input[name="sum"]'));

           // console.log("total : " + total);
        });
        $('#sumOrderProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        $('#sumProduct').text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        $('#finalPrice').val(total);
    }

 */


$(document).ready(function() {
    init();
    $('#totalProduct').text(document.getElementsByClassName('prod').length);

    //   doSum();
    //    doTotal();
});