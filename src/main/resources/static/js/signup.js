$(document).ready(function() {
    $('#sign-form').submit(function(event) {

        var register_form = {
            id: $('#id').val(),
            name: $('#name').val(),
            password: $('#password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/signup',
            data: register_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                        // 성공시 확인 버튼 클릭 후 login 페이지로
                        alert('회원가입이 성공적으로 완료되었습니다.');

                        // 성공 시 회원가입 모달창 닫기
                        const modal = document.getElementById('sign-box');
                        const background = document.getElementById("background");
                        modal.style.display = 'none';
                        background.style.display = 'none';

                        // 성공 시 로그인 모달창 열기
                        const loginModal = document.getElementById('login-box');
                        const loginBackground = document.getElementById("background");
                        loginModal.style.display = 'block';
                        loginBackground.style.display = 'block';
                        // 스크롤 방지
                        const currentScrollY = window.scrollY;
                        document.body.style.position = 'fixed';
                        document.body.style.width = '100%';
                        document.body.style.top = `-${currentScrollY}px`; // 현재 스크롤 위치
                        document.body.style.overflowY = 'scroll';

                } else {
                    if (json.name === "false") {
                        //이미 존재하는 이름
                        alert("이미 존재하는 이름입니다.");
                    } else if (json.namenull === "false") {
                        // 이름 미입력
                        alert("이름을 입력해주세요.");

                    }else if (json.id === "false") {
                        //이미 존재하는 아이디
                        alert("이미 존재하는 아이디입니다.")
                    } else if (json.idnull === "false") {
                        // 아이디 미입력
                        alert("아이디을 입력해주세요.");

                    }else if (json.password === "false") {
                        // 비밀번호 미입력
                        alert("비밀번호를 입력해주세요.");
                    }

                    else {
                        alert("다시 시도해주세요.")
                    }
                }
            }
        });

        return false;

    });
});
