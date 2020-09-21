package me.iseunghan;

public class Main {

    public static void main(String[] args) {
        int[] citations = {6,6,6,6,6,1};
        H_index hIndexSolution = new H_index();
        int result = hIndexSolution.run(citations);
        System.out.println("result = " + result);
    }
}
