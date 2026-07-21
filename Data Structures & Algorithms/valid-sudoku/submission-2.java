class Solution {
    public boolean isValidSudoku(char[][] board) {
        int start[][]={{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        if(!checkValid(board,start)){
            return false;
        }
        for(int i=0;i<board.length;i++){
            boolean seen[]=new boolean[10];
            int r=i;
            int c=i;
            for(int j=0;j<board.length;j++){
                char ch=board[i][j];
                if(ch=='.'){
                    continue;
                }
                int num=ch-'0';
                if(seen[num]){
                    return false;
                }
                seen[num]=true;
            }
            boolean seen1[]=new boolean[10];
            for(int j=c;j<board.length;j++){
                char ch=board[j][i];
                if(ch=='.'){
                    continue;
                }
                int num=ch-'0';
                if(seen1[num]){
                    return false;
                }
                seen1[num]=true;
            }
        }
        return true;
    }

    private boolean checkValid(char[][] board, int[][] start) {

    for (int i = 0; i < start.length; i++) {
        boolean[] seen = new boolean[10];

        int r = start[i][0];
        int c = start[i][1];

        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                char ch = board[r + j][c + k];

                if (ch == '.') {
                    continue;
                }

                int num = ch - '0';

                if (seen[num]) {
                    return false;
                }

                seen[num] = true;
            }
        }
    }

    return true;
}
}
