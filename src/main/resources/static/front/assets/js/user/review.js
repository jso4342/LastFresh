/*
*  review modules
* */

console.log("Review Modules......");

let reviewService = (function () {
//    댓글 목록
    function reviewGetList(param, callback, error) {
        let sellProductNum = param.sellProductNum;
        let page = param.page || 1;

        $.getJSON("/reviews/list/" + sellProductNum + "/" + page, function (reviewPageDTO){
            if (callback){
                callback(reviewPageDTO.reviewCount, reviewPageDTO.list);
            }
        }).fail(function (xhr, status, er) {
            if(error){
                error(er);
            }
        });
        // $.ajax({
        //     type: "GET",
        //     url: "/reviews/list/" + sellProductNum + "/" + page,
        //     success: function (list) {
        //         if(callback){
        //             callback(list);
        //         }
        //     },
        //     error: function (xhr, status, er) {
        //         if (error) {
        //             error(er);
        //         }
        //     }
        // });
    }

    //댓글 조회
    function readReview(reviewNum, callback, error) {
    $.get("/reviews/" + reviewNum, function (result) {
        if(callback){
            callback(result);
        }
    }).fail(function (xhr, status, er) {
        if(error){
            error(er);
        }
    })
    }
    return {reviewGetList: reviewGetList, readReview: readReview}
})();
