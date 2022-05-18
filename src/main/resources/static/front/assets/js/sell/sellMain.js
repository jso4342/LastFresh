let $sideSnb = $('.inner_snb li a');

$.each($sideSnb, function (i, e) {
    let index = 0;
    $(e).click(function () {
        index = i

        for (let j = 0; j < $sideSnb.length; j++){
            $sideSnb[j].classList.remove("menuClicked")
        }

        $sideSnb[index].classList.add("menuClicked");
    });
});

/*div 높이 변화시, 전체 높이 변경*/
let $pageDiv = $('.page_section');

$pageDiv.change(function () {
    let height = $('.page_section').height() + 100;

    $('.sellMenuRegister').css("height", height);
});