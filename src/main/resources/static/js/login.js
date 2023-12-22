$(document).ready(function() {
    $('#login-form').submit(function(event) {
        var login_form = {
            id: $('#login_id').val(),
            password: $('#login_password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/login',
            data: login_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    // 로그인 성공
                    alert('로그인 되었습니다.');

                    // 로그인 성공 시 로그인 모달창 닫기
                    const modal = document.getElementById('login-box');
                    const background = document.getElementById("background");
                    modal.style.display = 'none';
                    background.style.display = 'none';

                    // 로그인 성공 시 메인으로
                    window.location.href = "/";

                    // 스크롤 허용
                    document.body.style.position = '';
                    document.body.style.width = '';
                    document.body.style.top = '';
                    document.body.style.overflowY = '';
                    window.scrollTo(0, prevScrollY);

                } else {
                        alert("아이디 및 비밀번호를 확인해주세요.");
                }
            }
        });

        return false;

    });
});
