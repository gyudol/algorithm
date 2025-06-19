class Solution {
    public int[] solution(int brown, int yellow) {
        for (int width = 3; width < brown / 2; width++) {
            for (int height = 3; height <= width; height++) {
                if (width * height == brown + yellow && 
                    (width - 2) * (height - 2) == yellow) {  // xy = brown + yellow
                    return new int[] {width, height};
                }
            }
        }
        
        return null;
    }
}