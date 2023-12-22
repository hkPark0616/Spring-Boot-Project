// modal show
$(document).on("click", ".popupBtn", function(event) {
    const modal = document.getElementById('login-box');
    const background = document.getElementById("background");

    modal.style.display = 'block';
    background.style.display = 'block';

    // 스크롤 방지
    const currentScrollY = window.scrollY;
    document.body.style.position = 'fixed';
    document.body.style.width = '100%';
    document.body.style.top = `-${currentScrollY}px`; // 현재 스크롤 위치
    document.body.style.overflowY = 'scroll';
    return currentScrollY;
});

// closeBtn click modal off
$(document).on("click", ".close-button", function(event) {

        const modal = document.getElementById('login-box');
        const signinModal = document.getElementById('sign-box');
        const background = document.getElementById("background");

        modal.style.display = 'none';
        background.style.display = 'none';
        signinModal.style.display = "none";

        // 스크롤 허용
        document.body.style.position = '';
        document.body.style.width = '';
        document.body.style.top = '';
        document.body.style.overflowY = '';
        window.scrollTo(0, prevScrollY);

});

//background click modal off
window.onclick = function(event) {
    const modal = document.getElementById('background');
    const loginModal = document.getElementById('login-box');
    const signinModal = document.getElementById('sign-box');
    if (event.target == modal) {
        modal.style.display = "none";
        loginModal.style.display = "none";
        signinModal.style.display = "none";
    }

    // 스크롤 허용
    document.body.style.position = '';
    document.body.style.width = '';
    document.body.style.top = '';
    document.body.style.overflowY = '';
    window.scrollTo(0, prevScrollY);
}


/* -------------------------- login ==> signin ------------------------ */

$(document).on("click", ".gosignin", function(event) {

    const loginModal = document.getElementById('login-box');
    const signinModal = document.getElementById('sign-box');

    loginModal.style.display = 'none';
    signinModal.style.display = 'block';

    // 스크롤 방지
    const currentScrollY = window.scrollY;
    document.body.style.position = 'fixed';
    document.body.style.width = '100%';
    document.body.style.top = `-${currentScrollY}px`; // 현재 스크롤 위치
    document.body.style.overflowY = 'scroll';
    return currentScrollY;
});

/* -------------------------- signin ==> login ------------------------ */

$(document).on("click", ".gologin", function(event) {

    const loginModal = document.getElementById('login-box');
    const signinModal = document.getElementById('sign-box');

    loginModal.style.display = 'block';
    signinModal.style.display = 'none';

    // 스크롤 방지
    const currentScrollY = window.scrollY;
    document.body.style.position = 'fixed';
    document.body.style.width = '100%';
    document.body.style.top = `-${currentScrollY}px`; // 현재 스크롤 위치
    document.body.style.overflowY = 'scroll';
    return currentScrollY;
});
