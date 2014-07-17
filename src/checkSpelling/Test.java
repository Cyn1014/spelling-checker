package checkSpelling;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new FileReader("/usr/share/dict/words"));
		String line=null;
		TrieTree dict=new TrieTree();
		while((line=br.readLine())!=null){
			dict.addWord(line);
		}
		br.close();
		//Run Test Case
		String right="people";
		for(int i=0;i<100;i++){
			System.out.print(">");
			String word=MistakeGenerator.misSpelling(right);
			System.out.print(word);
			System.out.println();
			System.out.println(SpellingChecker.checkSpelling(word,dict.getRoot()));
			
		}
	}

}
