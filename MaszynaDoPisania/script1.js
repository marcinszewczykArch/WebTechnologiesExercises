function showNewsHeading(){
    let newsHeading = document.getElementById("news")
    console.log(newsHeading.innerHTML);
}
function showFirstNews(){
    let newsList = document.getElementById("news-list")
    let firstNews = newsList.getElementsByTagName("li")[0];
    console.log(firstNews.innerHTML);
}
function showSportNews(){
    let sportNews = document.querySelectorAll("ul#sport-news > li")
    sportNews.forEach(element => console.log(element.innerHTML))
    
    // for(let i = 0; i < sportNews.length; i++){
    //     console.log(sportNews[i].innerHTML)
    // }
}
function changeHeadings(){
    let news = document.getElementById("news");
    news.innerHTML = "Wesołe Newsy";
    let sport = document.getElementById("sport");
    sport.innerHTML = "Anty Sport";
}
function addDynamicClassToH2(){
    let h2Elements = document.getElementsByTagName("h2");
    for(let i = 0; i < h2Elements.length; i++) {
        const emement = h2Elements[i];
        emement.classList.add("dynamic");
    }
}
function addDynamicClassToSecondNews(){
    let News = document.querySelectorAll("ul#news-list > li");
    let SportNews = document.querySelectorAll("ul#sport-news > li");
    
    News[1].classList.add("dynamic");
    SportNews[1].classList.add("dynamic");
}
function addDynamicClassToFirstNews(){
    let firstBullet = document.querySelectorAll("ul > li:nth-child(1)");
    const addDynamicClass = element => element.classList.add("dynamic2");
    firstBullet.forEach(addDynamicClass);
}
function addSportNews(newsToBeAdded) {
    let newsList = document.querySelector("#sport-news");
    let li = document.createElement("li");
    let text = document.createTextNode(newsToBeAdded);
    li.appendChild(text);
    newsList.appendChild(li);
}
function removeNewsByNumber(number){
    let secondNews = document.querySelector(`#news-list > li:nth-child(${number})`);
    secondNews.remove();
}

removeNewsByNumber(2)
addSportNews("Niemcy odpadają z mundialu");
addSportNews("Kubica wygrywa kolejny wyścig w F1");

for(let i = 5; i > 1; i--){
    let news = "Kubica wygrywa " + i + " wyścig w F1 z rzędu";
    addSportNews(news);
}
addSportNews("Kubica wygrywa pierwszy wyścig w F1");

addDynamicClassToFirstNews();
addDynamicClassToSecondNews();
addDynamicClassToH2();
setTimeout(changeHeadings, 3000);
showNewsHeading();
showFirstNews();
showSportNews();


