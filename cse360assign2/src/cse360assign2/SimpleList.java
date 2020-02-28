//Joshua Yi
//#178
//creating repositories and uploading to them.

package cse360assign2;
public class SimpleList
{
	private int list[];
	private int count;

	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	public void add(int a) {
		if(count == list.length) {	
			int size = (int)Math.floor(list.length * 1.5);
			int temp[] = new int[size];
			
			for (int inx = 0; inx < list.length; inx++){
			      temp[inx] = list[inx];
			   }
			   list = temp;
		}
		
		if(count > 0) {
			for(int inx = count; inx > 0; inx--) {
				list[inx] = list[inx - 1];
			}
		}
		count++;
		list[0] = a;
	}
	
	public void remove(int r) {
		boolean found = false;
		
		if(count > 1) {
			double reduce = count/(list.length - 1);
			int space = 1;
			
			if(reduce > .25) {
				
				while(reduce > .25) {
					reduce = count/(list.length - space);
					space++;
				}
				
				int temp[] = new int[list.length - space];
				
				for (int inx = 0; inx < list.length; inx++){
				      temp[inx] = list[inx];
				   }
				   list = temp;
			}
		}
		
		for(int inx = 0; inx < count; inx++) {
			
			if(list[inx] == r) {
				found = true;
			}
			
			if(found) {
				
				for(int jinx = inx; jinx < count - 1; jinx++) {
					list[jinx] = list[jinx + 1];
					inx--;
				}
				count = count - 1;
			}
			found = false;
		}
	}
	
	public void append(int c) {
		if(count == list.length - 1) {	
			
			int size = (int)Math.floor(list.length * 1.5);
			int temp[] = new int[size];
			
			for (int inx = 0; inx < list.length; inx++){
			      temp[inx] = list[inx];
			   }
			   list = temp;
		}
		list[count] = c;
		count++;
	}
	
	public int count() {
		return count; //this statement returns the current count of the array
	}
	
	public String toString() {
		String string = "";
		
		if(count != 0) {
			
			for(int inx = 0; inx < count; inx++) {
				string = string + list[inx];

				if(inx < count - 1) {
					string = string + " ";
				}
			}
		}
		return string;
	}
	
	public int search(int s) {
		
		for(int inx = 0; inx < count; inx++) {
			
			if(list[inx] == s) {
				return inx;
			}
		}
		return -1;
	}
	
	public int first() {
		if(list[0] == '\0') {
			return -1;
		}
		return list[0];
	}
	
	public int last() {
		if(list[list.length - 1] == '\0') {
			return -1;
		}
		return list[list.length - 1];
	}
	
	public int size() {
		int inx = 0;
		int counter = 0;
		int spaces = 0;
		
		while(list[inx] != '\0') {
			counter++;
			inx++;
		}
		
		spaces = list.length - counter;
		return spaces;
	}
}
