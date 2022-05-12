/* userSelect */
// $( document ).ready(function() {
//     $('.myLabel').get(i).css("background-color",'red').css("color",'white');
//     $('.myLabel').click(function(){
//     });
// });


// $('input[type=radio]').each(function (i,radio) {
//     $(radio).on("click",function () {
//         if(라디오버튼이 체크){
//             해당 라디오버튼의 라벨의 css변경
//             $($(".myLabel").get(i)).css('background-color','#DA291C').css("color",'white');
//         }
//     })
// })

$('input[type=radio]').each(function (i,radio) {
    $(radio).on("click", function () {
        $(".myLabel").css('background-color','#fff').css("color",'#333');
        if($(radio).prop("checked")){
            console.log($(this).next());
            $(this).next().css('background-color','#DA291C').css("color",'white');
            //왜 this로 해야 하는지 질문,,,반복문 돈 뒤~
        }
    })
})

// $('input[type=radio]').each(function (i,radio) {
//     $(radio).on("click",function () {
//         if( $(radio).removeAttr("checked")){
//             $($(".myLabel").get(i)).css('background-color','white').css("color",'black');
//         }
//     })
// })


/* userJoin */
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
    $(오케이).on("click",function () {
        $($(".modal").get(i)).hide();
    })
})

$('.modal').each(function (i,modal) {
    $(modal).on("click",function () {
        $(this).hide();
        // $($(".modal").get(i)).hide();
    })
})
/* 체크박스 */
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