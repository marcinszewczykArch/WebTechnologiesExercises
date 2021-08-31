package pl.javastart.lotterygame;

import java.util.ArrayList;

public class LotteryResult {

    LotteryDrawing userInput;
    LotteryDrawing randomNumbers;
    ArrayList<Integer> matchedNumbersArray;

    public LotteryResult(LotteryDrawing userInput, LotteryDrawing randomNumbers, ArrayList<Integer> matchedNumbersArray) {
        this.userInput = userInput;
        this.randomNumbers = randomNumbers;
        this.matchedNumbersArray = matchedNumbersArray;
    }

    public LotteryDrawing getUserInput() {
        return userInput;
    }

    public LotteryDrawing getRandomNumbers() {
        return randomNumbers;
    }

    public ArrayList<Integer> getMatchedNumbersArray() {
        return matchedNumbersArray;
    }
    
    public String printMatchedNumbers(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer number : matchedNumbersArray) {
            sb.append(number.toString() + ", ");
        }
        if(matchedNumbersArray.size()>0) {
            sb.replace(sb.lastIndexOf(", "), sb.lastIndexOf(", ")+2, "");
        }
        sb.append("]");
        return sb.toString();
    }
    
    
}
