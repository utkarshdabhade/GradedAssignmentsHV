
let list = document.querySelector("#list1")

let category = document.getElementById("navbarDropdown")
let mainText = document.querySelector(".mainPagetext")

var dataGlobal;

const getData = async () => {
    const response = await fetch("https://dummyjson.com/products");
    const data = await response.json();
    dataGlobal = data;
    return data;
};

(async () => {
    await getData();
    //console.log(dataGlobal);
})();
async function fetchData() {
    mainText.innerHTML = ''
    dataGlobal.products.map((element) => {

        list.innerHTML +=
            `     <div class="card " style="font-size: 10px;width: 240px; height: 280px; margin: 6px;" id="${element.title}">
            <img src="${element.thumbnail}" style="height: 80px; width: 100%" class="card-img-top" alt="...">
            <div class="card-body align-self-center" >
              <h5 class="card-title" >${element.title}</h5>
              <p class="card-text">${element.description}</p>
             
            </div>
            <a href="#" class="btn btn-outline-primary">Add to Cart</a>
          </div>
    `
    })

}


async function loadCategory() {

    dataGlobal.products.map((ele)=>{
        category.innerHTML
    })

}

let inputBox = document.querySelector("#inputText");
inputBox.addEventListener('keydown', (event) => {
    var etvalue = inputBox.value;
    let dl = dataGlobal.products;
  
    const matchedTokens = dl.filter((obj) => {
        return (obj.title.toLocaleLowerCase().indexOf(etvalue.toLocaleLowerCase()) !== -1);
    });
    list.innerHTML = ``;
  
    //console.log(matchedTokens.length + ' ' + dl.length + ' ' + etvalue);

    matchedTokens.map((element) => {
        let ul = document.getElementById('list1');
        ul.innerHTML +=
            `<div class="card " style="font-size: 10px;width: 240px; height: 280px; margin: 6px;" id="${element.title}">
            <img src="${element.thumbnail}"style="height: 80px; width: 100%" class="card-img-top" alt="...">
            <div class="card-body align-self-center" >
              <h5 class="card-title" >${element.title}</h5>
              <p class="card-text">${element.description}</p>
             
            </div>
            <a href="#" class="btn btn-primary ">Add to cart</a>
          </div>
    `
    });
   

})

