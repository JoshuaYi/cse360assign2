//Joshua Yi
//#178
//Assignment number 2
//Description: Working on/building upon previous assignment.
//			   Adding new methods and modifying existing ones.
//			   discovering how to upload onto github and the practicality of it.

package cse360assign2;
public class SimpleList
{
	private int list[];
	private int count;
	
	public SimpleList() {
		list = new int[10];
		count = 0;
	}
	
	//adding method which adds user defined value into the front of the array
	public void add(int a) {
		
		//if list is full and user is trying to add onto list, it creates a temp
		//list to make original list larger
		if(count == list.length && count > 1) {	
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
	
	//removes user input value from array
	public void remove(int r) {
		boolean found = false;
		
		//whenever remove is called, this if statement checks for unnecessary
		//space then removes all of it.
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
	
	//adds user input integer to the end of the array
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
	
	//method returns the count of the array
	public int count() {
		return count; //this statement returns the current count of the array
	}
	
	//method prints the content of the array
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
	
	//this method searches for the user input. returns number if found, -1 if not
	public int search(int s) {
		
		for(int inx = 0; inx < count; inx++) {
			
			if(list[inx] == s) {
				return inx;
			}
		}
		return -1;
	}
	
	//method checks if the array is empty. returns number if it is
	//not empty and -1 if it is
	public int first() {
		if(list[0] == '\0') {
			return -1;
		}
		return list[0];
	}
	
	//same as last method but prints out last value in array. -1 if empty.
	public int last() {
		if(list[0] == '\0') {
			return -1;
		}
		int counter = 0;
		int inx = 0;
		
		while(list[inx] != '\0') {
			counter++;
			inx++;
		}
		return list[counter+1];
	}
	
	//method calculates the unused space in array and returns that value
	public int size() {
		int inx = 0;
		int counter = 0;
		int spaces = 0;
		
		while(list[inx] != '\0') {
			counter++;
			inx++;
		}
		
		spaces = (list.length) - (counter) - 1;
		return spaces;
	}
}
