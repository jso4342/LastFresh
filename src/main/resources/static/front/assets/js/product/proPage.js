$("a.layout-pagination-number").click(function (e) {
    e.preventDefault();
    $(pageForm).find("input[name='[pageNum]").val($(this).attr("href"));
    $(pageForm).submit();
})