// Aislinn O'Connell
// CS 143
// HW Core Topics: LinkedIntList HW
//
// This program will creates an object that can store a list
// of integer values. Integers can be added to the list and/or
// at an index as well as other LinkedIntLists can be added at a
// certain index. Integers can be removed at a index, too. The
// size of the list, the value at a certain index, and the index 
// of a certain value are values that can all be returned. This 
// program can also compare the LinkedIntList to another object 
// see if they are equal. 

public class LinkedIntList implements IntList {
   private int size; 
   private Node start;
   
   // Adds value to end of list and increases size - Passed
   public void add(int value) {
      Node temp = new Node();
      temp.data = value; 
      if (start != null) {
         Node current = start;
         while(current.next != null) {
            current = current.next;
         }
         current.next = temp; 
         size++;
     } else {
         start = temp;
         size++;
     }
 
   } 
  
   // Prints out completed LinkedIntList to a String - Passed
   public String toString() {
      Node current = start; 
      if(size == 0) {
         return "[]";
      } else {
         String result = "[" + current.data;
         current = current.next; 
         for(int i = 1; i < size; i++) {
            result += ", " + current.data;
            current = current.next; 
         }
         result += "]";
         return result;
      }
   }
	
   // Returns size of LinkedIntList - Passed
   public int size() {
      Node temp = start;
      int totalSize = 0;
      while(temp != null) {
         temp = temp.next;
         totalSize++;
      }
      return totalSize;
   }
   
   // Gets the value at a given index - Passed
   public int get(int index) {
      checkIndex(index); 
      Node temp = start;
      for(int i = 0; i < index; i++) {
         temp = temp.next;
      }
      return temp.data;
   }
   
   // Finds the index of value - Passed
   public int indexOf(int value) {
      Node temp = start;       
      for(int i = 0; i < size; i++) {
         if(temp.data == value) {
            return i;
         }
         temp = temp.next; 
      } 
      return -1;
   }
   
   // Private helper method
   private void checkIndex(int index) {
      if (index < 0 || index >= size) {
         throw new IndexOutOfBoundsException("index: " + index);
      }
   }
	
   // Adds a value to the LinkedIntList at a certain index - Passed
   public void add(int index, int value) {
      checkIndex(index);
      Node temp = new Node();
      temp.data = value;
      Node current = start; 
      if (start != null) {
         for(int i = 0; i < index - 1; i++) {
            current = current.next;
         }  
         temp.next = current.next; 
         current.next = temp;  
         size++;
      } else {
         start = temp;
         size++;
      }             
   }
   
   // Removes the value at a given index
	public void remove(int index) {
      checkIndex(index);
      Node current = start;
      for(int i = 0; i < index - 1; i++) {
         current = current.next;
      }   
      current.next = current.next.next;  
      size--;    
   }
   
   // Checks if another Object is equal to the LinkedIntList - Passed 
   public boolean equals(Object object) {
      // self check
      if (this == object) 
         return true; 
      // null check
      if (object == null)
         return false;
      // type check and cast
      if (getClass() != object.getClass())
         return false;
      LinkedIntList list = (LinkedIntList) object;
      // list size comparison
      if (size != list.size()) {
         return false;
      }
      // Value of each element comparison
      Node temp = start; 
      for (int x = 0; x < size; x++) {
         if (temp.data != list.get(x)) {
            return false;
         }
         temp = temp.next; 
      }
      return true;
   }
   
   // Adds an additional LinkedIntList in at a given index - Passed
   public void insertList(int index, LinkedIntList list) {
      checkIndex(index);
      Node current = start; 
      for(int i = 0; i < index - 1; i++) {
         current = current.next;
      }
      Node newList = list.start;  
      for(int i = 0; i < list.size() - 1; i++) {
         newList = newList.next;  
      } 
      newList.next = current.next; 
      current.next = list.start;  
      size = list.size + size;               
   }         

}

/* Output
  ----jGRASP exec: java junit_runner.JgrRunner 60346 LinkedIntListTest
 Running 8 JUnit tests
 
 Completed 8 tests  8 passed
 */