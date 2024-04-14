let goToFindButton = document.getElementById('goToFindButton');

function changeContainer(event, id){
    event.preventDefault();
    let containers = document.querySelectorAll('.container');
    for(let i = 0; i < containers.length; i++){
        if(containers[i].id === id){
            containers[i].style.display = "flex";
        }
        else{
            containers[i].style.display = "none";
        }
    }
}

goToFindButton.addEventListener('click', event => changeContainer(event, 'find'));


let joinPasswordCheckBox = document.getElementById('joinPasswordCheckBox');
let joinPasswordBox = document.getElementById('joinPasswordBox');

joinPasswordCheckBox.addEventListener('input', function(){
    if((joinPasswordBox.value !== joinPasswordCheckBox.value) && (joinPasswordBox.value !== "")){
        document.querySelector('.joinCheck:nth-of-type(2)').style.display = "block";
    }
    else{
        document.querySelector('.joinCheck:nth-of-type(2)').style.display = "none";
    }
});

joinPasswordBox.addEventListener('input', function(){
    if((joinPasswordBox.value != joinPasswordCheckBox.value) && (joinPasswordCheckBox.value !== "")){
        document.querySelector('.joinCheck:nth-of-type(2)').style.display = "block";
    }
    else{
        document.querySelector('.joinCheck:nth-of-type(2)').style.display = "none";
    }
})