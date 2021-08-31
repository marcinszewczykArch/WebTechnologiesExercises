package pl.javastart.lotterygame;

import java.util.ArrayList;
import java.util.Arrays;

public class LotteryChecker {

    static LotteryResult lotteryChecker (LotteryDrawing userInput, LotteryDrawing randomNumbers){
         ArrayList<Integer> userInputArray = new ArrayList<>();
         ArrayList<Integer> randomNumbersArray = new ArrayList<>();
         ArrayList<Integer> matchedNumbersArray = new ArrayList<>();

         userInputArray.add(userInput.getN1());
         userInputArray.add(userInput.getN2());
         userInputArray.add(userInput.getN3());
         userInputArray.add(userInput.getN4());
         userInputArray.add(userInput.getN5());
         userInputArray.add(userInput.getN6());

         randomNumbersArray.add(randomNumbers.getN1());
         randomNumbersArray.add(randomNumbers.getN2());
         randomNumbersArray.add(randomNumbers.getN3());
         randomNumbersArray.add(randomNumbers.getN4());
         randomNumbersArray.add(randomNumbers.getN5());
         randomNumbersArray.add(randomNumbers.getN6());

         for (Integer randomNumber : randomNumbersArray) {
             for (Integer userInputNumber : userInputArray) {
                 if(randomNumber == userInputNumber){
                     matchedNumbersArray.add(userInputNumber);
                 }
             }
         }
         return new LotteryResult(userInput, randomNumbers, matchedNumbersArray);
    }



}
