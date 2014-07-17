package checkSpelling;

public class TrieTree {

	private TrieNode root;
	
	public TrieTree(){
		root=new TrieNode(' ');
	}
	
	public void addWord(String word){
		char[] chs=word.toCharArray();
		TrieNode node=root;
		for(char ch:chs){
			node=node.addChild(ch);
		}
		if(chs.length>0)
		node.addChild(' ');
	}
	
	public TrieNode getRoot(){
		return root;
	}
	

}
