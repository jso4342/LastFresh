

// const modal = document.querySelector('.modal');
// const btnOpenPopup = document.querySelector('.link_btn_agree');
// btnOpenPopup.addEventListener('click', () => {
//     modal.style.display = 'block';
// });
// modal.addEventListener('click', ()=>{
//     modal.style.display='none';
// });
/*상혁씨 코드*/
//

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
