function createHeading() {
    const text = "HELLO WORLD";
    const textContainer = document.getElementById("text-container");
    simulateTextMachine(textContainer, text);
}

function simulateTextMachine(element, text) {
    for (let i = 0; i < text.length; i++) {
        const letter = text.charAt(i);
        setTimeout(() => element.append(letter), (i + 1) * 200);
    }
}

createHeading();