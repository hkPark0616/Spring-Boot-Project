var check = false;


$(document).on("click", ".underLine", function(event) {

    const modal = document.getElementById('UserInfo');
    const arrow =document.getElementById('arrow');


    if(!check){
        modal.style.display = 'flex';
        arrow.style.transform = 'rotate(-180deg)';
        check = true;

    }else{
        modal.style.display = 'none';
        arrow.style.transform = 'rotate(0deg)';
        check = false
    }
});
