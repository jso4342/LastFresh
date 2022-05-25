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
        
        //댓글 작성 시간(Controller)
        function getReviewDateByController(reviewDate) {
            $.ajax({

            });
        }
        
        //댓글 작성 시간(Javascript)
        function getReviewDateByJavascript(reviewDate) {
            let today = new Date();
            let rDate = new Date();
            let gap = today.getTime() - rDate.getTime();

            if (gap < 1000 * 60 * 60 * 24){

            }else {
                
            }
        }
    }
    return {reviewGetList: reviewGetList, readReview: readReview}
})();
