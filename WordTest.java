import java.io.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class TestCase {

    private String word;
    private boolean correct = false;

    public TestCase(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void changeResult(boolean result) {
        correct = result;
    }

}

class WordTest {

    public static void main(String[] args) {

        List<TestCase> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the words");
        while(true) {
            
            String word = scanner.nextLine();
            if(word.equals("none")) break;

            list.add(new TestCase(word));
        
        }
        if(list.size() == 0) return;

        for(TestCase testCase: list) {
            
            System.out.println(testCase.getWord());
            System.out.println("Is the answer correct? (yes/no)");

            String yesOrNo = scanner.nextLine();
            if(yesOrNo.equals("yes")) testCase.changeResult(true);
            if(yesOrNo.equals("no")) testCase.changeResult(false);
            
            System.out.println();
        }

        System.out.println("The words you missed");

        double incorrect = 0;
        for(TestCase testCase: list) {
            if(!testCase.isCorrect()) {
                System.out.println(testCase.getWord());
                incorrect++;
            }
        }
        if(incorrect == 0) System.out.println("There are no mistakes. You are PERFECT!!");

        double accuracyRate = list.size() - incorrect;
        accuracyRate /= list.size();
        accuracyRate *= 100;

        System.out.println("Accuracy rate is " + accuracyRate + "%");

    }

}
