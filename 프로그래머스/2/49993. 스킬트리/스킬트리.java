import java.util.Arrays;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        return (int) Arrays.stream(skill_trees)
            .map(skill_tree -> skill_tree.replaceAll("[^" + skill + "]", ""))
            .filter(skill_tree -> skill.startsWith(skill_tree))
            .count();
    }
}