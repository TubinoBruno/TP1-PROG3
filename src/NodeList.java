
public class NodeList {
	protected Node root;
	protected int size;
	NodeList(){
		root=null;
		size=0;
	}
	public void insert(Object o){
		Node tmp = new Node(o, null);
		tmp.setNext(root);
		root = tmp;
		size++;
	}
	public void insertAtEnd(Object o){

		if(isEmpty()){
			insert(o);
		}
		else{
			Node aux = root;
			while(aux.getNext() != null){
				aux = aux.getNext();
			}
			aux.setNext(new Node(o,null));
			size++;
		}

	}

	public void insertAt(int pos, Object o){

		if(pos < size() && pos >= 0){	
			if(pos == 0){
				insert(o);
			}
			else if( pos == size()-1){
				insertAtEnd(o);
			}
			else{
				int count = 0;
				Node aux = root;
				while(count < size()-1){
					if(count == pos){
						Node newNode = new Node(o, aux.getNext());
						aux.setNext(newNode);
						size++;
						count = size();
					}
					else{
						aux = aux.getNext();
						count++;
					}
				}
			}
		}

	}
	public Object extract(){
		Object info=null;
		if(root!=null){
			info=root.getInfo();
			root=root.getNext();
		}
		size--;
		return info;  
	}

	public void print(int n){
		Node tmp=root;
		int i=1;
		while(i<=n){
			tmp=tmp.getNext();
			if(i==n){
				System.out.println(tmp.getInfo());
			}
			i++;
		}
	}
	public void print(){
		Node tmp=root;
		while(tmp!=null){
			System.out.println(tmp.getInfo());
			tmp=tmp.getNext();
		}
	}

	public boolean isEmpty(){
		return root==null;
	}
	public int size (){
		return size;  
	}
	public boolean contains(Object o){

		if(!isEmpty()){	
			int count = 0;
			Node aux = root;
			while(count < size()){
				if(aux.getInfo().equals(o)){
					return true;
				}
				aux = aux.getNext();
				count++;
			}
		}
		return false;
	}
	public Object getElementAt(int pos){

		if( pos >= 0  && pos < size() ){	
			int count = 0;
			Node aux = root;
			while(pos != count){
				aux = aux.getNext();
				count++;
			}
			return aux.getInfo();
		}
		return null;
	}
	public static NodeList createIntersectionList(NodeList a, NodeList b){

		NodeList newList = new NodeList();

		for (int i = 0; i < a.size(); i++) {

			Object element = a.getElementAt(i);
			if(b.contains(element)){
				newList.insertAtEnd(element);
			}	
		}
		return newList;
	}
	public Object max(){

		if(isEmpty()){	
			return null;
		}
		else if(size() == 1){
			return root.getInfo();
		}
		Node aux = root;
		Object max = root.getInfo();
		Object current = null;
		int pos = 0;
		while(pos < size){
			current = aux.getInfo();
			if((int)max < (int)current){
				max = current;
			}
			aux = aux.getNext();
			pos++;
		}
		return max;
	}
	public boolean removeFirstOcurrence(Object o){

		if(!isEmpty()){
			if (root.getInfo().equals(o)) {
				removeFirst();
				return true;
			}
			else{
				Node aux = root;
				while(aux.getNext() != null){
					if(aux.getNext().getInfo().equals(o)){
						Node temp = aux.getNext().getNext();
						aux.getNext().setNext(null);
						aux.setNext(temp);
						size--;
						return true;
					}
					aux = aux.getNext();
				}			
				if(aux.getInfo().equals(o)){
					removeLast();
					return true;
				}
			}	
		}
		return false;
	}
	public void removeFirst(){

		if(!isEmpty()){
			Node temp = root;
			root = root.getNext();	
			temp.setNext(null);
			size--;
		}	
	}

	public void removeLast(){

		if(size() <= 1){
			removeFirst();
		}
		else{
			Node aux = root;
			int count = 0;
			while(count < size()-2){
				aux = aux.getNext();
				count++;
			}
			aux.setNext(null);
			size--;
		}

	}
	public static NodeList sort(NodeList l) {

		NodeList newList = new NodeList();
		while(!l.isEmpty()){
			Object max = l.max();
			l.removeFirstOcurrence(max);
			newList.insert(max);
		}
		return  newList;
	}
	
}
