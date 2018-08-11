package array.data_structures;
public class Test {

	public static void main(String[] args) {
		Array<Integer> arr = new Array<>();
		for (int i = 0; i < 10; i++) {
			arr.addLast(i);
		}
		System.out.println(arr.toString());
		
		arr.add(2, 44);
		System.out.println(arr.toString());
		System.out.println(arr.getItem(0));
		
		arr.remove(0);
		System.out.println(arr.toString());
		arr.removeEle(44);
		System.out.println(arr.toString());
	}
}
