package checkSpelling;

public class SpellingChecker {
	
	public static String checkSpelling(String word,TrieNode root){
		char[] chs=word.toCharArray();
		int m=chs.length;
		int[] record=new int[m];
		int i=0;
		//0: no change; 1: case error; 2:repeated letter; 
		//3: vowel a; 4: vowel e; 5: vowel i; 6: vowel o; 7: vowel u;
		//8: vowel A; 9: vowel E; 10: vowel I; 11: vowel O; 12: vowel U;
		TrieNode node=root;
		int j=0;
		while(i>=0){
			if(i==m){
				if(node.findChild(' ')!=null){
					StringBuilder sb=new StringBuilder();
					TrieNode temp=node;
					while(temp!=root){
						sb.insert(0, temp.getCharacter());
						temp=temp.getParent();
					}
					return new String(sb);
				}else{
					
					i--;
					if(i<0)
						break;
					j=record[i];
					if(j==2)
					while(i-1>=0 && record[i-1]==2){
						i--;
					}
					else
						node=node.getParent();
					j++;
				}
			}
			if(j==0){
				TrieNode next=node.findChild(chs[i]);
				if(next!=null){
					record[i]=j;
					i++;
					node=next;
					j=0;
				}else {
					j++;
				}
			}else if(j==1){
				TrieNode next=node.findChild(changeCase(chs[i]));
				if(next!=null){
					record[i]=j;
					i++;
					node=next;
					j=0;
				}else {
					j++;
				}
			}else if(j==2){
				if(i-1>=0 && chs[i-1]==chs[i]){
					char pre=chs[i-1];
					record[i]=j;
					while(i+1<m && chs[i+1]==pre){
						i++;
						record[i]=j;
					}
					j=0;
					i++;
				}else {
					j++;
				}
			}else if(j==3){
				if(isVowel(chs[i])){
					if(chs[i]!='a' && changeCase(chs[i])!='a'){
						TrieNode next=node.findChild('a');
						if(next!=null){
							record[i]=j;
							i++;
							node=next;
							j=0;
						}else {
							j++;
						}
					}else{
						j++;
					}
				}else{
					
					i--;
					if(i<0)
						break;
					j=record[i];
					if(j==2)
					while(i-1>=0 && record[i-1]==2){
						i--;
					}
					else
						node=node.getParent();
					j++;
				}
			}else if(j<13){
				char vowel=getVowel(j);
				if(chs[i]!=vowel && changeCase(chs[i])!=vowel){
					TrieNode next=node.findChild(vowel);
					if(next!=null){
						record[i]=j;
						i++;
						node=next;
						j=0;
					}else {
						j++;
					}
				}else{
					j++;
				}
			}else {
				
				i--;
				if(i<0)
					break;
				j=record[i];
				if(j==2)
				while(i-1>=0 && record[i-1]==2){
					i--;
				}
				else
					node=node.getParent();	
				j++;
			}
			
		}
		
		return "NO SUGGESTION";
	}
	
	//change case from upper to lower or lower to upper
	public static char changeCase(char c){
		if(c<'a')
			return (char)(c+32);
		return (char)(c-32);
	}
	
	//check whether is vowel
	public static boolean isVowel(char c){
		return c=='a' || c=='e' || c=='i' || c=='o' || c=='u'
		      ||c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
	}
	
	//get vowel
	public static char getVowel(int i){
		switch(i){
		case 4:return 'e';
		case 5:return 'i';
		case 6:return 'o';
		case 7:return 'u';
		case 8:return 'A';
		case 9:return 'E';
		case 10:return 'I';
		case 11:return 'O';
		case 12:return 'U';
		case 3:return 'a';
		default:return' ';
		}
	}
}
