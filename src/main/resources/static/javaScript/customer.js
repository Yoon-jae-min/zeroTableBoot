function changeContainer(id){
    let containers = document.querySelectorAll('.container');

    for(let i = 0; i < containers.length; i++){
        if(containers[i].id == id){
            containers[i].style.display = "flex";
        }
        else{
            containers[i].style.display = "none";
        }
    }
}