$(document).ready(function() {
    $.ajax({
        type:'GET',
        url:'/getList',
        dataType: 'json',
        success: function (data) {
            if(data.length <= 0){
                var html = '';
                html =
                    `
                    <li>
                        <a>"No Project"</a>
                    </li>
                    `;
                $(".project-list").append(html);
            }
            // exist data
            else{
                var html = '';
                for(let i = 0;i < 4;i++){
                    const list = data[i];
                    console.log(list.title);
                    // 1.
                    // <a th:href="@{'/post/detail/' + ${board.id}}" title="${list.title}" >${list.title}</a>
                    html +=
                        `
                        <li>
                            <!-- 2 -->
                            <a href="/post/detail/ + ${list.id}" title="${list.title}" >${list.title}</a>
                        </li>
                        `;
                }

                $(".project-list").append(html);
            }
        },
        error: function (error) {
            console.error("post list receive failed...");
        }
    });
});
