var check = false;

const $category = $('.gnb_menu li');

function send(){
    if(check == false) {
        $('.gnb_sub').show();
        /*	$('#allCategory').css({
                "color" : "#DA291C",
                "font-weight" : "600"
            });*/
        check = true;
    }else {
        $('.gnb_sub').hide();
        /*$('#allCategory').css({
            "color" : "#333",
            "font-weight" : "500"
        });*/
        check = false;
    }
}

$.each($category, function(index, item){
    $(item).mouseover(function(){
        $category.addClass("current");
    })
});

