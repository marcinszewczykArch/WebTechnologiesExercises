function Game(gameTitle, gameNote, gameDetails) {
    this.gameTitle = gameTitle;
    this.gameNote = gameNote;
    this.gameDetails = gameDetails;
}

let games = [];

function addGame(Game) {
    let tableRef = document.getElementById("baza-gier");
    let newRow = tableRef.insertRow(1);

    let newCell0 = newRow.insertCell(0);
    let newText0 = document.createTextNode(Game.gameTitle);
    newCell0.appendChild(newText0);

    let newCell1 = newRow.insertCell(1);
    let newText1 = document.createTextNode(Game.gameNote.toString());
    newCell1.appendChild(newText1);

    let newCell2 = newRow.insertCell(2);
    newCell2.appendChild(createDetailsButton());

    let newCell3 = newRow.insertCell(3);
    newCell3.appendChild(createDeleteButton());

    games.push(Game)
}

function readUserInput(){
const gt = document.forms["formularz"].elements.title.value;
const gn = document.forms["formularz"].elements.note.value;
const gd = document.forms["formularz"].elements.details.value;

let gameCanBeAdded = true;

    if ((gn<1 | gn>10 ) | (gn % 0.5 > 0)) {
        gameCanBeAdded = false;
        alert("ocena musi być z przedzialu 1-10 ze skokiem co 0.5");
    } else {
        for(let i = 0; i < games.length; i++){
            if(games[i].gameTitle == gt){
                gameCanBeAdded = false;
                alert("gra jest już w bazie");
            }
        }
    }

    if(gameCanBeAdded){
        game = new Game(gt, gn, gd);
        addGame(game)
        alert('gra została dodana');
    }
    
}

function gameAddedByUser(){
let addGameButton = document.getElementById("add-game-button");
addGameButton.addEventListener("click", readUserInput)
}

function createButton(text) {
    let button = document.createElement("button");
    let buttonBody = document.createTextNode(text);
    button.appendChild(buttonBody);
    return button;
}
    
function createDetailsButton() {
    let detailsButton = createButton("Pokaż szczegóły");
    detailsButton.onclick = () => {
        let rowIndex = games.length - (detailsButton.parentNode.parentNode.rowIndex - 0);
        console.log(detailsButton.parentNode.parentNode.rowIndex - 1);
        let game = games[rowIndex];
        let gameDetailsParagraph = document.getElementById("opis-gry");
        gameDetailsParagraph.textContent = `Opis gry: ${game.gameDetails}`;
    };
    return detailsButton;
}

function createDeleteButton() {
    let deleteButton = createButton("Usuń");
    deleteButton.onclick = () => {
        let tableRow = deleteButton.parentNode.parentNode;
        let tableBody = tableRow.parentNode;
        let gameIndex = tableRow.rowIndex - 1;
        tableBody.deleteRow(gameIndex);
        games.splice(gameIndex, 1);
    };
    return deleteButton;
}

addGame(new Game("Wiedźmin 3", 10, "Fantastyczna gra o walce z potworami i jeżdzeniu na koniu."));
addGame(new Game("Starcraft", 7, "Walki kosmitów i różnych ras."));
addGame(new Game("The Sims", 8, "Buduj domy, rozwijaj relacje. Prawdziwe życie w realnym świecie."));
addGame(new Game("Cyberpunk 2077", 9, "GTA, tylko że w przyszłości"));

gameAddedByUser();
