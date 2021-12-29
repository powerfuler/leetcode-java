package gp.DFS;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		List<List<String>> chessboard = new NQueens().solveNQueens(4);
		for (List<String> list: chessboard) {
			for (String s: list) {
				System.out.println(s + " ");
			}
			System.out.println();
		}
	}
    List<List<String>> solveNQueens(int n) {
      List<List<String>> results = new ArrayList<>();
      if (n <= 0) {
    	  return results;
      }
      //....
      search(results, new ArrayList<Integer>(), n);
      return results;
    }
    

    //cols.get(0,1).... 0,1 就是colIndex
    public void search(List<List<String>> results, List<Integer> cols, int n) {
    	if (cols.size() == n) {
    		results.add(drawChessboard(cols));
    		return;
    	}
    	for (int colIndex = 0; colIndex < n; colIndex++) {
    		if (!isValid(cols, colIndex)) {
    			continue;
    		}
    		cols.add(colIndex);
    		search(results, cols, n);
    		cols.remove(cols.size() - 1);
    	}
    }
    
    private boolean isValid(List<Integer> cols, int column) {
    	int row = cols.size();
    	for (int rowIndex = 0; rowIndex < cols.size(); rowIndex++) {
    		//同一竖线
    		if (cols.get(rowIndex) == column) {
    			return false;
    		}
    		//左到右斜线
    		if (rowIndex - cols.get(rowIndex) == row - column) {
    			return false;
    		}
    		//右到左斜线
    		if (rowIndex + cols.get(rowIndex) == row + column) {
    			return false;
    		}
    	}
    	return true;
    }
    public List<String> drawChessboard(List<Integer> cols) {
    	List<String> chessboard = new ArrayList<>();
    	for (int i = 0; i < cols.size(); i++) {
    		StringBuilder sb = new StringBuilder();
    		for (int j = 0; j < cols.size(); j++) {
    			sb.append(j == cols.get(i) ? 'Q' : '.');
    		}
    		chessboard.add(sb.toString());
    	}
    	return chessboard;
    }

}