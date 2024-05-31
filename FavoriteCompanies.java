import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FavoriteCompanies {
    public static List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> out = new ArrayList<>();

        for(int i=0; i<favoriteCompanies.size(); i++){
            Set<String> temp = new HashSet<>(favoriteCompanies.get(i));
            List<String> list1 = favoriteCompanies.get(i);
            int j = 0;
            for(j=0; j<favoriteCompanies.size(); j++){
                if (i==j){
                    continue;
                }

                Set<String> temp1 = new HashSet<>(favoriteCompanies.get(j));
                if(temp1.size() < list1.size()){
                    continue;
                }
                int p = 0;
                for(p=0; p<list1.size(); p++){
                    if(!temp1.contains(list1.get(p))){
                        break;
                    }
                }
                if(p == list1.size()){
                    break;
                }
            }
            if(j == favoriteCompanies.size()){
                out.add(i);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        List<List<String>> favoriteCompanies = new ArrayList<>();
        favoriteCompanies.add(List.of("leetcode","google","facebook"));
        favoriteCompanies.add(List.of("google","microsoft"));
        favoriteCompanies.add(List.of("google","facebook"));
        favoriteCompanies.add(List.of("google"));
        favoriteCompanies.add(List.of("amazon"));
        System.out.println(peopleIndexes(favoriteCompanies));
    }
}
