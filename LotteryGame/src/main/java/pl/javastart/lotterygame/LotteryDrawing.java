package pl.javastart.lotterygame;

public class LotteryDrawing {
    int n1;
    int n2;
    int n3;
    int n4;
    int n5;
    int n6;

    public LotteryDrawing(int n1, int n2, int n3, int n4, int n5, int n6) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
        this.n4 = n4;
        this.n5 = n5;
        this.n6 = n6;
    }

    static int getRandomNumber() {
        int random = (int) (Math.random() * 50 + 1);
        return random;
    }

    static LotteryDrawing randomLotteryDrawing(){
        LotteryDrawing randomLotteryDrawing = new LotteryDrawing(getRandomNumber(), getRandomNumber(), getRandomNumber(), getRandomNumber(), getRandomNumber(), getRandomNumber());
        return randomLotteryDrawing;
    }

    public int getN1() {
        return n1;
    }

    public int getN2() {
        return n2;
    }

    public int getN3() {
        return n3;
    }

    public int getN4() {
        return n4;
    }

    public int getN5() {
        return n5;
    }

    public int getN6() {
        return n6;
    }
}

