
public class Programa {
	public static void main(String []args){

		NodeList list1 = new NodeList();
		list1.insert(1);
		list1.insert(5);
		list1.insert(6);
		list1.insert(9);
		list1=list1.sort(list1);
		
		
		NodeList list2 = new NodeList();
		list2.insert(3);
		list2.insert(7);
		list2.insert(5);
		list2.insert(9);
		list2.insert(11);

		list2=list2.sort(list2);
		NodeList list3 = new NodeList();
		list3.createIntersectionList(list1, list2);
		list3=list3.createIntersectionList(list1, list2);
		list3.print();

	}
}
