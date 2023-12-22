$(document).ready(function () {

    $('#write-button').click(function (event) {

        event.preventDefault();

        $.ajax({
            type: 'GET',
            url: '/post',
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    // 관리자

                    window.location.href = "/write";

                } else {
                    alert("관리자만 접근 가능합니다.");
                    window.location.href = "/list";
                }
            }
        });
    });

});

