//for shopping cart toggle
let shoppingCart = document.querySelector('.shopping-cart')
document.querySelector('#cart-btn').onclick=()=>{
    shoppingCart.classList.toggle('active');
} 

let content = document.querySelector(".content");
let showProductList = document.querySelector("#list1");
let showCategryProduct = document.querySelector("#categoryProduct");
let carousel1 = document.querySelector("#carousel1")
let category = document.querySelector(".custom-select")
let categorySelect = document.getElementById('#select')


let carousel2 = document.querySelector("#carousel2");
var dataGlobal = [];
var categoryData = [];

async function getData() {
    const response = await fetch("https://dummyjson.com/products");
    const data = await response.json();
    dataGlobal =data.products;
    const newar = [];
    
    //----get distinct category ----
    for (let i = 0; i < dataGlobal.length; i++) {
        const element = dataGlobal[i].category;
         newar.push(element)
      }
     // -- distinct category --
     categoryData = newar.filter((ele, i, ar) => { return ar.indexOf(ele) === i })
    //  console.log(categoryData);

    //----------load carausel 2------------- 
    loadcarousel2();

    //-----------load category  -------------
    loadCategory();

}
async function fetchproducts() {
    content.innerHTML = '';
    carousel1.innerHTML ='';
   
    dataGlobal.map((element)=>{
        showProductList.innerHTML += `<div class="card " style="font-size: 10px;width: 240px; height: 350px;
         margin: 6px; border: 2px solid  rgb(21, 37, 82)  box-shadow: 10px 3px 15px #464444;" id="${element.title}">
        <img src="${element.thumbnail}" style="height: 100px; width: 100%" class="card-img-top" alt="...">
        <div class="card-body align-self-center" >
          <h5 class="card-title" >${element.title}</h5>
          <p class="card-text" >${element.description}</p>
          <p class="card-text" style="font-weight:bold" >Price: ${element.price}</p>
        
        </div>
        <a href="#" class="btn btn-outline-primary">Add to Cart</a>
      </div>
`
    })

carousel2.innerHTML += ``

}
async function loadCategory() {
    // category.innerHTML='';
    categoryData.forEach(element => {
        category.innerHTML += `<option class="dropdown-item" value="${element}" >${element}</option>`
   });

}



 function selectOption(){
    let selected = category.value;
    content.innerHTML = '';
    carousel1.innerHTML ='';
    showProductList.innerHTML='';
     
 

    for (let i = 0; i < dataGlobal.length; i++) {
        const element = dataGlobal[i].category;
            if(element===selected){
               
                    showProductList.innerHTML += `<div class="card " style="font-size: 10px;width: 240px; height: 350px;
                     margin: 6px; border: 2px solid  rgb(21, 37, 82)  box-shadow: 10px 3px 15px #464444;" id="${dataGlobal[i].title}">
                    <img src="${dataGlobal[i].thumbnail}" style="height: 100px; width: 100%" class="card-img-top" alt="...">
                    <div class="card-body align-self-center" >
                      <h5 class="card-title" >${dataGlobal[i].title}</h5>
                      <p class="card-text" >${dataGlobal[i].description}</p>
                      <p class="card-text" style="font-weight:bold" >Price: ${dataGlobal[i].price}</p>
                 
                    </div>
                    <a href="#" class="btn btn-outline-primary">Add to Cart</a>
                  </div>
            `
                
            }
      }

}


let randomNo1 = Math.floor(Math.random()*30)
let randomNo2 = Math.floor(Math.random()*30)
let randomNo3 = Math.floor(Math.random()*30)



async function loadcarousel2(){

 
            let element = dataGlobal[randomNo1]
            let element2 = dataGlobal[randomNo2]
            let element3 = dataGlobal[randomNo3]
         console.log(randomNo1,'cara2');


        carousel2.innerHTML += `   <div class="carousel-item active">
        <div class="row row-cols-1 row-cols-md-3 g-4"  >
          <div class="col">
            <div class="card" >
              <img
                src="${element.images[0]}"
                class="card-img-top" alt="Project 4">
           
            </div>
          </div>
          <div class="col">
            <div class="card">
              <img
                src="${element.images[1]}"
                class="card-img-top" alt="Project 5">
            
            </div>
          </div>
          <div class="col">
            <div class="card" >
              <img
                src="${element.images[2]}"
                class="card-img-top" alt="Project 6">
           
            </div>
          </div>
        </div>
      </div>
      <div class="carousel-item ">
      <div class="row row-cols-1 row-cols-md-3 g-4"  >
        <div class="col">
          <div class="card" >
            <img
              src="${element2.images[0]}"
              class="card-img-top" alt="Project 4">
         
          </div>
        </div>
        <div class="col">
          <div class="card">
            <img
              src="${element2.images[1]}"
              class="card-img-top" alt="Project 5">
          
          </div>
        </div>
        <div class="col">
          <div class="card" >
            <img
              src="${element2.images[2]}"
              class="card-img-top" alt="Project 6">
         
          </div>
        </div>
      </div>
    </div>
    <div class="carousel-item ">
    <div class="row row-cols-1 row-cols-md-3 g-4"  >
      <div class="col">
        <div class="card" >
          <img
            src="${element3.images[0]}"
            class="card-img-top" alt="Project 4">
       
        </div>
      </div>
      <div class="col">
        <div class="card">
          <img
            src="${element3.images[1]}"
            class="card-img-top" alt="Project 5">
        
        </div>
      </div>
      <div class="col">
        <div class="card" >
          <img
            src="${element3.images[2]}"
            class="card-img-top" alt="Project 6">
       
        </div>
      </div>
    </div>
  </div>

`

}









