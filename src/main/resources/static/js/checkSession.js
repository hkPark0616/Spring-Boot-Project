$(document).ready(function(){
    $.ajax({
        url: '/sessionCheck',
        type: 'GET',
        dataType: 'json',
        success: function(json) {
            if (json.success === "true") {
                // 세션이 있을 경우 글쓰기, 수정, 삭제 버튼 O
                $('.button-box').css("display", "flex");
                $('.write-button').css("display", "block");
            } else {
                // 세션이 없을 경우 글쓰기, 수정, 삭제 버튼 X
                $('.button-box').css("display", "none");
                $('.write-button').css("display", "none");
            }
        }
    });
});
