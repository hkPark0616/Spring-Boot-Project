// // smartEditor2
// let oEditors = [];
//
// function smartEditor(){
//     nhn.husky.EZCreator.createInIFrame({
//         oAppRef: oEditors,
//         elPlaceHolder: "content",
//         sSkinURI: "/smarteditor/SmartEditor2Skin.html",
//         fCreator: "createSEditor2",
//         htParams: {
//             bUseImageResizer: true,
//         }
//     });
// }
//
// $(document).ready(function (){
//     smartEditor();
// });
//
//
// $(document).ready(function() {
//     $('#form').submit(function(event) {
//         oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
//
//         var post_form = {
//             title: $('#title').val(),
//             writer: $('#writer').val(),
//             content: $('#content').val()
//         };
//
//         $.ajax({
//             type: 'POST',
//             url: '/post',
//             data: post_form,
//             dataType: 'json',
//             success: function (json) {
//                 if (json.success === "true") {
//                     // 로그인 성공
//                     alert('글 작성이 완료되었습니다.');
//
//                     window.location.href = "/list";
//
//
//                 } else {
//                     alert("제목 및 내용을 작성해주세요.");
//                     oEditors.getById["content"].exec("FOCUS"); //포커싱
//                     return;
//                 }
//             }
//         });
//
//         return false;
//
//     });
//
//     // 이미지 업로드
//     // $('#imageInput').on('change', function() {
//     //     var formData = new FormData();
//     //     formData.append('upload', $(this)[0].files[0]);
//     //
//     //     $.ajax({
//     //         type: 'POST',
//     //         url: '/smarteditorMultiImageUpload',
//     //         data: formData,
//     //         processData: false,
//     //         contentType: false,
//     //         success: function (response) {
//     //             // 이미지 업로드 성공 시, 스마트에디터에 이미지 추가
//     //             var imageInfo = response.split("&");
//     //             var imageUrl = decodeURIComponent(imageInfo[2].split("=")[1]);
//     //             oEditors.getById["content"].exec("PASTE_HTML", ['<img src="' + imageUrl + '" style="max-width:100%;">']);
//     //         }
//     //     });
//     // });
// });
