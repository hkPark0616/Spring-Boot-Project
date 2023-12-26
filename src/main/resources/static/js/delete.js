
$(document).ready(function() {
    $("#delete-btn").on("click", function(event) {
        var confirmDelete = confirm('게시물을 삭제하시겠습니까?');

        if (!confirmDelete) {
            event.preventDefault();
        }else{
            alert("삭제되었습니다.");
        }

    });

});

// $(document).ready(function() {
//     // 삭제 버튼 클릭 시 이벤트 처리
//     $("#delete-btn").on("click", function() {
//         // 확인 대화상자 표시
//         if (confirm("게시글을 삭제하시겠습니까?")) {
//             // 확인을 누르면 서버로 게시글 삭제 요청
//             deletePost();
//
//         } else {
//             // 취소를 누르면 아무 동작 없음
//             return false;
//         }
//     });
// });
//
// // Update Fuction
// function deletePost() {
//     $('#delete-form').submit(function(event) {
//         var postId = $('#post-id').val();
//
//         $.ajax({
//             type: "DELETE", // 또는 "GET" 등 적절한 HTTP 메서드 사용
//             url: `/post/delete/${postId}`,
//             dataType: 'json',
//             success: function (json) {
//                 if (json.success === "true") {
//
//                     alert("게시글이 삭제되었습니다.");
//
//
//                     window.location.href = "list";
//                 }else{
//                     alert("게시글 삭제에 실패하였습니다. 잠시 후 다시 시도해주세요.");
//                 }
//
//                 // 삭제 성공 시 알림 표시 후 /main으로 이동
//
//             },
//             error: function (error) {
//                 alert("게시글 삭제에 실패하였습니다. 잠시 후 다시 시도해주세요.");
//             }
//         });
//     });
// }
