let menu = document.querySelector('#menu');
let article = document.querySelector('article');
let menuButton = document.querySelector('#menu-button');
let menuContent = document.querySelectorAll('.menu-content');
let menuContentIcons = document.querySelectorAll('.menu-content-icon');
let menuContentTexts = document.querySelectorAll('.menu-content-text');

let logoText = document.getElementById('logo-text');

//메뉴

menu.addEventListener("mouseover", () => {
    menu.classList.add("active");
    article.classList.add("active");
    menuContent.forEach(content => content.classList.add("active"));
    menuContentIcons.forEach(icon => icon.classList.add("active"));
    menuContentTexts.forEach(text => {
        text.style.display = "flex";
        text.style.animation = "fadeIn 1s ease forwards";
    });
});

menu.addEventListener("mouseout", () => {
    menu.classList.remove("active");
    article.classList.remove("active");
    menuContent.forEach(content => content.classList.remove("active"));
    menuContentIcons.forEach(icon => icon.classList.remove("active"));
    menuContentTexts.forEach(text => {
        text.style.animation = "fadeOut 1s ease forwards";
        text.addEventListener("animationend", function(){
            if(!menu.classList.contains("active")){
                text.style.display = "none";
            }
        });
    });
});

menuButton.addEventListener("click", () => {

    if(menu.classList.contains('active')){
        menu.classList.remove("active");
        article.classList.remove("active");
        menuContent.forEach(content => content.classList.remove("active"));
        menuContentIcons.forEach(icon => icon.classList.remove("active"));
        menuContentTexts.forEach(text => {
            text.style.animation = "fadeOut 1s ease forwards";
            text.addEventListener("animationend", function(){
                if(!menu.classList.contains("active")){
                    text.style.display = "none";
                }
            });
        });
    }
    else{
        menu.classList.add("active");
        article.classList.add("active");
        menuContent.forEach(content => content.classList.add("active"));
        menuContentIcons.forEach(icon => icon.classList.add("active"));
        menuContentTexts.forEach(text => {
            text.style.display = "flex";
            text.style.animation = "fadeIn 1s ease forwards";
        });
    }
});

// menuContent.addEventListener("click")

function mobileMenuTouch(){
    if(window.innerWidth <= 767){
        menuContent.classList.remove("active");
        menuContent.classList.add("mobileMenuTouchActive");
    }
}



//로고 텍스트

function adjustLogoText(){
    if(window.innerWidth <= 767){
        logoText.style.opacity = "0";
        menuButton.style.opacity = "1";
    }
    else{
        logoText.style.opacity = "1";
        menuButton.style.opacity = "0";
    }
}

function adjustLogoTextResize(){
    if(window.innerWidth <= 767){
        logoText.style.animation = "fadeOut 0.5s ease forwards";
        menuButton.style.animation = "fadeIn 0.5s ease forwards";
    }else{
        menuButton.style.animation = "fadeOut 0.5s ease forwards";
        logoText.style.animation = "fadeIn 0.5s ease forwards";
    }
}

window.addEventListener("DOMContentLoaded", adjustLogoText);

window.addEventListener("resize", adjustLogoTextResize);
