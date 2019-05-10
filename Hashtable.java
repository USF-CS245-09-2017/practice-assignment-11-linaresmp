import java.util.*;
public class Hashtable{
	 int slot_num;
	static int size;
	 HashNode[] slot;
public Hashtable(){
		slot_num = 350000;
		slot = new HashNode[slot_num];
		size = 0;


	}
	static private class HashNode{
		String key; 
		String value;
		HashNode next;


		public HashNode(String key, String value){
			this.key = key;
			this.value= value;
			this.next = null;
			size = 0;
		}

	}


	


	public boolean containsKey(String key){
		int slotFinder = getItem(key);
		HashNode curr = slot[slotFinder];
		while(curr != null){
			if(curr.key.equals(key)){
				return true; 
			}
		} return false; 

	}

	

	String get(String key){
		int slotFinder = getItem(key);
		HashNode curr = slot[slotFinder];
		while(curr != null){
			if(curr.key.equals(key)){
				return curr.value;
			}curr = curr.next;
		}
		return null;
	}
String remove(String key){
		int slotFinder = getItem(key);
		HashNode curr = slot[slotFinder];
		HashNode prev = null; 
		while(curr.next != null && !curr.key.equals(key)){
			prev = curr; 
			curr = curr.next;

		}
		if(prev == null){
			slot[slotFinder] = curr.next;
		}
		if(curr.key.equals(key)){
			if(curr == null){
				return null; 
			}
		}
		return curr.value;
	}
	int getItem(String key){
		int h = key.hashCode();
		return Math.abs((h % slot_num));

	}
	void put(String key, String value){
		int slotFinder = getItem(key);
		HashNode curr  = slot[slotFinder];
		while(curr != null){
			if(curr.key.equals(key)){
				curr.key = key;
				curr.value = value;
				return;
			}
		}
		size++;
		HashNode n = new HashNode(key, value);
		n.next = slot[slotFinder];
		slot[slotFinder] = n;
	}






}