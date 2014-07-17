package checkSpelling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("/usr/share/dict/words"));
		String line=null;
		TrieTree dict=new TrieTree();
		while((line=br.readLine())!=null){
			dict.addWord(line);
		}
		br.close();
				
		while(true){
			System.out.println();
			System.out.print(">");
			Scanner scan=new Scanner(System.in);
			String word=scan.next();
			System.out.println(SpellingChecker.checkSpelling(word,dict.getRoot()));
		}
		

	}
	
	

}
