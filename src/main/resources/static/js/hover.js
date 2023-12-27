$(document).ready(function() {
    // 마우스를 올렸을 때 이벤트를 처리합니다.
    $('.hover').hover(
        function(e) {
            // 마우스를 올렸을 때의 동작

            let imgUrl = "";
            let val = $(this).attr('value');

            if(val === "university"){
                imgUrl = "/images/university.png";
            }

            else if(val === "document1"){
                imgUrl = "/images/document1.png";
            }

            else if(val === "document2"){
                imgUrl = "/images/document2.png";
            }

            else if(val === "toeic"){
                imgUrl = "/images/toeic.png";
            }

            console.log("Image URL:", imgUrl);
            var hoverDiv = $('<div id="hoverDiv"><img id="hoverImg" src="' + imgUrl + '"/></div>');

            // 동적으로 생성한 div를 body에 추가
            $('body').append(hoverDiv);

            // 위치를 설정하고 생성된 div를 표시
            hoverDiv.css({
                'top': e.pageY,
                'left': e.pageX
            }).fadeIn('slow');

        },
        function() {
            // 마우스를 벗어났을 때의 동작

            // 생성된 div를 숨깁니다.
            $('#hoverDiv').hide();

            // 생성된 div를 제거합니다.
            $('#hoverDiv').remove();
        }
    );
});