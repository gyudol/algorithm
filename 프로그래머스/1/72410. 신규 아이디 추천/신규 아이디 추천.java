class Solution {
    private static final int LIMIT = 16;
    
    public String solution(String new_id) {
        new_id = new_id.toLowerCase().replaceAll("[^a-z0-9\\-_.]", "")
            .replaceAll("\\.{2,}", "\\.").replaceAll("^\\.+|\\.+$", "");
        
        if(new_id.isEmpty()) new_id = "a";
        else if(new_id.length() >= LIMIT) new_id = new_id.substring(0, LIMIT - 1)
            .replaceAll("\\.+$", "");
        while(new_id.length() <= 2) new_id += new_id.charAt(new_id.length() - 1);
        
        return new_id;
    }
}