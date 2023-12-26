$(document).ready(function () {
    $('#content').summernote({
        // 썸머노트 옵션 설정
        codeviewFilter: false,
        codeviewIframeFilter: false,
        disableXSSProtection: true,
        height: 500,
        width: 990,
        minHeight: null,
        maxHeight: null,
        focus: false,
        lang: 'ko-KR',
        toolbar: [
            // 스타일 관련 기능
            ['style', ['style']],

            ['fontname', ['fontname']],
            // 글자 크기 설정
            ['fontsize', ['fontsize']],
            // 글꼴 스타일
            ['font', ['bold', 'italic', 'underline', 'clear']],
            // 글자 색상
            ['color', ['color']],
            // 테이블 삽입
            ['table', ['table']],
            // 문단 스타일
            ['para', ['ul', 'ol', 'paragraph']],
            // 에디터 높이 설정
            ['height', ['height']],
            // 이미지, 링크, 동영상 삽입
            ['insert', ['picture', 'link', 'video']],
            // 코드 보기, 전체화면, 도움말
            ['view', ['codeview', 'help']],
        ],
        fontSizes: [
            // 글자 크기 선택 옵션
            '8', '9', '10', '11', '12', '14', '16', '18', '20', '22', '24', '28', '30', '36', '50', '72'
        ],
        fontNames: [
            'Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋음체','바탕체'
        ],
        styleTags: [
            // 스타일 태그 옵션
            'p',
            { title: 'Blockquote', tag: 'blockquote', className: 'blockquote', value: 'blockquote' },
            'pre',
            { title: 'code_light', tag: 'pre', className: 'code_light', value: 'pre' },
            { title: 'code_dark', tag: 'pre', className: 'code_dark', value: 'pre' },
            'h1', 'h2', 'h3', 'h4', 'h5', 'h6'
        ],
        defaultStyle: 'text-align:left;',

        callbacks: {
            // 파일 업로드
            onImageUpload: function (files) {

                uploadSummernoteImageFile(files[0],this);
            },

            // 파일 업로드 후 파일 삭제
            onMediaDelete: function ($target, editor, $editable) {
                // 삭제된 이미지의 파일 이름을 알아내기 위해 split 활용
                if (confirm('이미지를 삭제하시겠습니까?')) {
                    var deletedImageUrl = $target.attr('src').split('/').pop()

                    // ajax 함수 호출
                    deleteSummernoteImageFile(deletedImageUrl);
                }
            },

            /* 사용자가 내용을 붙여넣을때, 이미지 파일이 포함되어 있다면, 해당 이벤트를 막아서
               이미지를 직접 붙여넣는 것을 방지 */
            onPaste: function (e) {
                var clipboardData = e.originalEvent.clipboardData;
                if(clipboardData && clipboardData.items && clipboardData.items.length){
                    var item = clipboardData.items[0];
                    if(item.kind === 'file' && item.type.indexOf('image/') !== -1){
                        e.preventDefault();
                    }
                }
            },
        },
    });
});

// 이미지 업로드 ajax
function uploadSummernoteImageFile(file, editor) {
    data = new FormData()
    data.append('file', file)
    $.ajax({
        data: data,
        type: 'POST',
        url: '/uploadSummernoteImageFile',
        dataType: 'json',
        contentType: false,
        processData: false,
        success: function (data) {
            $(editor).summernote('insertImage', data.url);
        },
    })
}

// 이미지 삭제 ajax
function deleteSummernoteImageFile(imageName) {
    data = new FormData()
    data.append('file', imageName)
    $.ajax({
        data: data,
        type: 'POST',
        url: '/deleteSummernoteImageFile',
        contentType: false,
        enctype: 'multipart/form-data',
        processData: false,
    })
}


// write ajax
$(document).ready(function() {
    $('#form').submit(function (event) {

        var post_form = {
            title: $('#title').val(),
            writer: $('#writer').val(),
            content: $('#content').summernote('code').trim()
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

                    return;
                }
            }
        });

        return false;

    });
});