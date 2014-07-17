package checkSpelling;

import java.util.HashMap;

public class TrieNode {
	
	private TrieNode parent;
	private char ch;
	
	private HashMap<Character,TrieNode> children=new HashMap<Character,TrieNode>();

	public TrieNode(char ch){
		parent=null;
		this.ch=ch;
	}
	
	public TrieNode(TrieNode node,char ch){
		this.parent=node;
		this.ch=ch;
	}
	
	public TrieNode addChild(char c){
		TrieNode child;
		if(children.containsKey(c)){
			child=children.get(c);
		}else{
			child=new TrieNode(this,c);
			children.put(c,child);
		}
		return child;
	}
	
	
	public TrieNode findChild(char c){
		if(children.containsKey(c))
			return children.get(c);
		return null;
	}
	
	public TrieNode getParent(){
		return parent;
	}
	
	public char getCharacter(){
		return ch;
	}
}
