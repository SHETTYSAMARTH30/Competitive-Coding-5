// Time Complexity : O(n^2) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {

        //Need to check whether numbers are repeating in a given row

        if(board == null || board.length != 9 || board[0].length != 9)
            return false;
        
        int m = board.length;
        int n = board[0].length;

        //Row :- if we find a number mark index as true
        for(int i = 0; i < 9; i++) {

            //keep track of all repetitions in a row
            boolean[] row = new boolean[9];

            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.')
                    continue;
                char ch = board[i][j];

                //if character already present then it is repetition
                if(row[(int)(ch - '1')])
                    return false;
                
                row[(int)(ch - '1')] = true;
            }
        }

        //Need to check whether numbers are repeating in a given col

        //Col:- if we find a number mark index as false
        for(int c = 0; c < 9; c++) {

            //keep track of all repetitions in a col
            boolean[] col = new boolean[9];
            for(int r = 0; r < 9; r++) {

                if(board[r][c] == '.')
                    continue;

                char ch = board[r][c];
                //if character is already present in a col then false
                if(col[(int)(ch - '1')])
                    return false;
                
                col[(int)(ch - '1')] = true;
            }
        }

        //Need to check whether numbers are repeating in a given block :- 3 * 3 matrix

        //Block :- 3*3 matrix 
        //There are 9 blocks 0 to 8
        for(int block = 0; block < 9; block++) {

            //create tracker for every block
            boolean blk[] = new boolean[9];

            for(int r = block/3 * 3; r < block/3*3 + 3; r++) {

                for(int c = block%3 * 3; c < block%3 * 3 + 3; c++) {

                    if(board[r][c] == '.')
                        continue;

                    char ch = board[r][c];

                    //in entire block number should not repeat
                    if(blk[(int)(ch - '1')])
                        return false;
                    
                    blk[(int)(ch - '1')] = true;
                }
            }
        }
        
        return true;
    }
}