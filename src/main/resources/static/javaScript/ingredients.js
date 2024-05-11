// let isSmallScreen = window.matchMedia('(max-width: 767px)').matches;
// let eachIngredients = document.querySelectorAll('.eachIngredient');
// let ingredientDetails = document.querySelectorAll('.ingredientDetails');
// let okButtons = document.querySelectorAll('.okButton');



// //재료 박스
// function addClickListener() {
//     // let ingredients = document.querySelectorAll('.eachIngredient');
//     eachIngredients.forEach(function(eachIngredient) {
//         eachIngredient.addEventListener('click', clickHandler);
//     });
//     okButtons.forEach(function(okButton){
//         okButton.addEventListener('click', clickHandler);
//     })
// }

// function removeClickListener() {
//     eachIngredients.forEach(function(eachIngredient) {
//         eachIngredient.removeEventListener('click', clickHandler);
//     });
// }

// function clickHandler() {
//     let details = this.querySelector('.ingredientDetails');

//     if (!this.classList.contains('detail')) {
//         this.classList.add('detail');
//         details.style.display = "block";
//         setTimeout(() => {
//             let detailsHeight = details.scrollHeight;
//             details.style.maxHeight = detailsHeight + "px";
//             this.style.height = detailsHeight + 80 + "px";
//         }, 10);
//     } else {
//         this.classList.remove('detail');
//         details.style.maxHeight = "0px";
//         this.style.height = "80px";
//     }
// }


// function handleResize() {
//     if (window.matchMedia('(max-width: 767px)').matches) {
//         addClickListener();
//         ingredientDetails.forEach(function(ingredientDetail){
//             ingredientDetail.style.display = "none";
//         });
//         eachIngredients.forEach(function(eachIngredient){
//             eachIngredient.style.height = "80px";
//         });
        

//     }
//     else {
//         removeClickListener();
//         ingredientDetails.forEach(function(ingredientDetail){
//             ingredientDetail.style.display = "flex";
//         });
//         eachIngredients.forEach(function(eachIngredient){
//             eachIngredient.style.height = "50px";
//         })
//     }
// }

// document.addEventListener("DOMContentLoaded", function() {
//     if (isSmallScreen) {
//         addClickListener();
//     }
// });

// window.addEventListener('resize', handleResize);







//
//
//
//let isSmallScreen = window.matchMedia('(max-width: 767px)').matches;
//let ingredientNames = document.querySelectorAll('.ingredientName');
//let eachIngredients = document.querySelectorAll('.eachIngredient');
//let ingredientDetails = document.querySelectorAll('.ingredientDetails');
//let okButtons = document.querySelectorAll('.okButton');
//
//
//
////재료 박스
//function addClickListener() {
//    // let ingredients = document.querySelectorAll('.eachIngredient');
//    ingredientNames.forEach(function(ingredientName) {
//        ingredientName.addEventListener('click', clickHandler);
//    });
//    okButtons.forEach(function(okButton){
//        okButton.addEventListener('click', clickHandler);
//    })
//}
//
//function removeClickListener() {
//    ingredientNames.forEach(function(ingredientName) {
//        ingredientName.removeEventListener('click', clickHandler);
//    });
//}
//
//function clickHandler() {
//    let details = this.closest('.eachIngredient').querySelector('.ingredientDetails');
//    let updateButtons = document.querySelectorAll('.updateButton');
//
//    updateButtons.forEach(function(updateButton){
//        updateButton.addEventListener('click',function(){
//            let detailsHeight = this.closest('.eachIngredient').querySelector('.ingredientDetails').scrollHeight;
//            details.style.maxHeight = '200px';
//            this.closest('.eachIngredient').style.height = detailsHeight + 80 + "px";
//        });
//
//    });
//
//
//    if (!this.closest('.eachIngredient').classList.contains('detail')) {
//        this.closest('.eachIngredient').classList.add('detail');
//        details.style.display = "block";
//        setTimeout(() => {
//            let detailsHeight = details.scrollHeight;
//            details.style.maxHeight = detailsHeight + "px";
//            this.closest('.eachIngredient').style.height = detailsHeight + 80 + "px";
//        }, 10);
//    } else {
//        this.closest('.eachIngredient').classList.remove('detail');
//        details.style.maxHeight = "0px";
//        this.closest('.eachIngredient').style.height = "80px";
//    }
//}
//
//
//function handleResize() {
//    if (window.matchMedia('(max-width: 767px)').matches) {
//        addClickListener();
//        ingredientDetails.forEach(function(ingredientDetail){
//            ingredientDetail.style.display = "none";
//        });
//        eachIngredients.forEach(function(eachIngredient){
//            eachIngredient.style.height = "80px";
//        });
//
//
//    }
//    else {
//        removeClickListener();
//        ingredientDetails.forEach(function(ingredientDetail){
//            ingredientDetail.style.display = "flex";
//        });
//        eachIngredients.forEach(function(eachIngredient){
//            eachIngredient.style.height = "50px";
//        })
//    }
//}
//
//document.addEventListener("DOMContentLoaded", function() {
//    if (isSmallScreen) {
//        addClickListener();
//    }
//});
//
//window.addEventListener('resize', handleResize);



let updateDeleteButtons = document.querySelectorAll('.updateDeleteButton');
let updateButtons = document.querySelectorAll('.updateButton');
let deleteButtons = document.querySelectorAll('.deleteButton');



updateButtons.forEach(function(updateButton){
    updateButton.addEventListener('click', function(){
        updateButton.parentElement.classList.remove('showButton');
        updateButton.parentElement.nextElementSibling.classList.add('showButton');

        let eachIngredient = this.closest('.eachIngredient');
        let ingredientTexts = eachIngredient.querySelectorAll('.ingredientText');
        let ingredientSettings = eachIngredient.querySelectorAll('.ingredientSetting');

        ingredientTexts.forEach(function(ingredientText, index){
            ingredientText.classList.add('hideInput');

            let settings = ingredientSettings[index];
            if(settings){
                if(index === 0){
                    let number = ingredientText.textContent.replace(/개/g, '').trim();
                    settings.querySelector('input').value = number;
                }
                else if(index === 1){
                    let select = settings.querySelector('select');
                    if(select){
                        let option = Array.from(select.options).find(option => option.textContent === ingredientText.textContent).value;
                        if(option) select.value = option;
                    }
                }
                else settings.querySelector('input').value = ingredientText.textContent;
            }
        });

        ingredientSettings.forEach(function(ingredientSetting){
            ingredientSetting.classList.add('showInput');
        });


        updateButton.parentElement.nextElementSibling.addEventListener('click', function(){
            this.classList.remove('showButton');

            ingredientTexts.forEach(function(ingredientText){
                ingredientText.classList.remove('hideInput');
            });

            ingredientSettings.forEach(function(ingredientSetting){
                ingredientSetting.classList.remove('showInput');
            });

            this.previousElementSibling.previousElementSibling.classList.remove('buttonClick');
        })

    });
});

deleteButtons.forEach(function(deleteButton){
    deleteButton.addEventListener('click', function(){
        updateDeleteButtons.forEach(function(updateDeleteButton){
            if(updateDeleteButton.classList.contains('buttonClick')){
                updateDeleteButton.nextElementSibling.classList.remove('showButton');
                updateDeleteButton.nextElementSibling.nextElementSibling.classList.add('showButton');

                updateDeleteButton.nextElementSibling.nextElementSibling.addEventListener('click',function(){
                    updateDeleteButton.nextElementSibling.nextElementSibling.classList.remove('showButton');
                    updateDeleteButton.classList.remove('buttonClick')
                })
            }
        });
    });
});



//----------------------------------------------------다시 작성 ------------------------------------------------------------------------


//재료 박스
const eachIngredients = document.querySelectorAll('.eachIngredient');
const ingredientDetails = document.querySelectorAll('.ingredientDetails');

eachIngredients.forEach(eachIngredient => {
    const updateDeleteContainer = document.querySelector('.updateDeleteContainer');
    const updateDeleteButton = document.querySelector('.updateDeleteButton');
    const eachIngredientName = document.querySelector('.ingredientName');


    eachIngredient.addEventListener("mouseenter", function(){
        eachIngredient.classList.add("open");
    })

    eachIngredient.addEventListener("mouseleave", function(){
        eachIngredient.classList.remove("open");
        updateDeleteContainer.classList.remove("showContainer");
        updateDeleteButton.classList.remove("buttonClick");
    })

    eachIngredientName.addEventListener("click", function(){
        const eachIngredientNameParent = eachIngredientName.parentNode;

          if(eachIngredientNameParent.classList.contains("open")){
               eachIngredientNameParent.classList.remove("open");
               updateDeleteContainer.classList.remove("showContainer");
               updateDeleteButton.classList.remove("buttonClick");
          }
          else{
            eachIngredientNameParent.classList.add("open");
          }
    })
})




//재료 삽입
let foodInputButton = document.getElementById('foodInputButton');
let inputBox = document.getElementById('inputBox');
let addButton = document.getElementById('addButton')

foodInputButton.addEventListener('click', function(){
    if(foodInputButton.classList.toggle('buttonClick')) inputBox.classList.add('addBox');
    else inputBox.classList.remove('addBox');

    if(foodInputButton.classList.contains('buttonClick')){
        addButton.addEventListener('click', function(){
            inputBox.classList.remove('addBox');
            foodInputButton.classList.remove('buttonClick');
        });
    }
});


document.addEventListener('DOMContentLoaded', function(){
    document.querySelector('#inputBox ul li:nth-child(7) input').value = new Date().toISOString().substring(0, 10);
});


//재료 수정, 삭제
//let updateDeleteButtons = document.querySelectorAll('.updateDeleteButton');
//let updateButtons = document.querySelectorAll('.updateButton');
//let deleteButtons = document.querySelectorAll('.deleteButton');

//수정, 삭제 메뉴 버튼
updateDeleteButtons.forEach(updateDeleteButton => {
    updateDeleteButton.addEventListener('click', function(event){
        console.log("버튼 클릭");

        const updateDeleteContainer = document.querySelector('.updateDeleteContainer');

        updateDeleteButton.classList.add('buttonClick');
        updateDeleteContainer.classList.add('showContainer');
    });
});