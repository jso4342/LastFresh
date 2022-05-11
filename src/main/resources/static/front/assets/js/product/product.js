var cart = $(".cart_option");
var button = $(".cancel");
$(".group_btn").click(function(){
    $(cart).removeClass("off");
    $(cart).css("opacity", "1");
    $(".bg_loading").css("display", "block");
});

$(button).click(function(){
    $(cart).addClass("off");
    $(cart).css("opacity", "0");
    $(".bg_loading").css("display", "none");
});