$(document).ready(function() {
    $('#form').submit(function(event) {
        var post_form = {
            title: $('#title').val(),
            writer: $('#writer').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/post',
            data: post_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    // 로그인 성공
                    alert('글 작성이 완료되었습니다.');

                    window.location.href = "/list";


                } else {
                    alert("제목 및 내용을 작성해주세요.");
                }
            }
        });

        return false;

    });
});
