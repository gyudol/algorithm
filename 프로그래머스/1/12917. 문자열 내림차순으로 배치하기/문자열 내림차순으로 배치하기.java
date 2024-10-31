class Solution {
    public String solution(String s) {
        return s.chars().boxed()
            .sorted((c1, c2) -> Integer.compare(c2, c1))
            .collect(StringBuilder::new,
                    StringBuilder::appendCodePoint,
                    StringBuilder::append).toString();
    }
}