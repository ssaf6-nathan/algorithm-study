package PROGRAMMERS;

import java.util.HashMap;

public class 위장 {
    
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int c = 0; c < clothes.length; c++) {

            map.put(clothes[c][1], map.getOrDefault(clothes[c][1], 0)+1);
            System.out.println(map.values());
        }

        return clothes.length * map.values();
    }
}
