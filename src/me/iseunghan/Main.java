package me.iseunghan;

public class Main {

    public static void main(String[] args) {
        /*int[] citations = {6,6,6,6,6,1};
        H_index hIndexSolution = new H_index();
        int result = hIndexSolution.run(citations);
        System.out.println("result = " + result);*/

        /*int[] numbers = {3, 30, 34, 5, 9};
        Max_number max_number = new Max_number();
        String result = max_number.run(numbers);
        System.out.println("result = " + result);*/

        /*String[][] clothes = {{"crow_mask", "face"},{"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        Spy_Clothes spyClothes = new Spy_Clothes();
        int result = spyClothes.run(clothes);
        System.out.println("result = " + result);*/

        /*int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        Target_Number target_number = new Target_Number();
        int result = target_number.run(numbers, target);
        System.out.println("result = " + result);*/

        /*String numbers = "011";
        Find_Demical find = new Find_Demical();
        int result = find.run(numbers);
        System.out.println("result = " + result);*/

        Stock_Price st = new Stock_Price();
        int[] prices = {5, 4, 3, 2, 1};
        int[] solution = st.solution(prices);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
