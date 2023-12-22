$(document).ready(function() {
    // 삭제 버튼 클릭 시 이벤트 처리
    $("#update").on("click", function() {
        // 확인 대화상자 표시
        if (confirm("게시글을 수정하시겠습니까?")) {
            // 확인을 누르면 서버로 게시글 삭제 요청
            updatePost();

        } else {
            // 취소를 누르면 아무 동작 없음
            return false;
        }
    });
});

// Update Fuction
function updatePost() {
    $('#update-form').submit(function(event) {
        var postId = $('#post-id').val();

        var update_form = {
            id: $('#post-id').val(),
            // createdDate: $('#createdDate').val(),
            title: $('#title').val(),
            writer: $('#writer').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: "PUT", // 또는 "GET" 등 적절한 HTTP 메서드 사용
            url: `/post/edit/${postId}`,
            data: update_form,
            dataType: 'json',
            success: function (json) {
                if (json.success === "true") {
                    // 로그인 성공
                    alert("게시글이 수정되었습니다.");
                    window.location.href = "/list";
                } else {
                    alert("제목 및 내용을 작성해주세요.");
                }
                // 삭제 성공 시 알림 표시 후 /main으로 이동

            },
            error: function (error) {
                alert("게시글 수정에 실패하였습니다. 잠시 후 다시 시도해주세요.");
            }
        });
    });
}


