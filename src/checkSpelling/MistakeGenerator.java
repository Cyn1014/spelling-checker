package checkSpelling;

import java.util.Random;

public class MistakeGenerator {
	
	public static String misSpelling(String word){
		StringBuilder sb=new StringBuilder();
		Random random=new Random();
		for(char ch:word.toCharArray()){
			int a=0;
			if(SpellingChecker.isVowel(ch)){
				a=random.nextInt(4);
			}else a=random.nextInt(3);
			switch(a){
			case 0:sb.append(ch);break;
			case 1:sb.append(SpellingChecker.changeCase(ch));break;
			case 2:int b=random.nextInt(20);
					for(int i=0;i<=b;i++)
						sb.append(ch);
					break;
			case 3:int c=random.nextInt(10);
			       sb.append(SpellingChecker.getVowel(c+3));
			}
			
		}
		
		return new String(sb);
	}
	
	

}
