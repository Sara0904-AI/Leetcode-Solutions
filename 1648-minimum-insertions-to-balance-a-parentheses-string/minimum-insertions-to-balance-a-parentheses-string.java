class Solution {
    public int minInsertions(String s) {
        int insert = 0;
        int track = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                if (track % 2 == 1){
                    insert++;
                    track--;
                }
                track += 2;
            }
            else {
                track--;

                if(track < 0){
                    insert++;
                    track += 2;
                }
            }
                    }
                    return insert+track;
    }
}