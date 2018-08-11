package array.data_structures;

public class Student {
	private String name;
	
	public Student(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {		
		return getName();
	}
	
	public static void main(String[] args) {
		Array<Student> arr = new Array<>();
		Student s = new Student("麻瓜");
		arr.addLast(new Student("小明"));
		arr.addLast(new Student("老王"));
		arr.addLast(s);
		
		System.out.println(arr.toString());
		
		arr.removeEle(s);
		System.out.println(arr.toString());
	}
}
