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
		if(count == 10) {
			list[9] = 0;
			count = count - 1;
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
}
