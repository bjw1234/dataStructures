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
		Student s = new Student("���");
		arr.addLast(new Student("С��"));
		arr.addLast(new Student("����"));
		arr.addLast(s);
		
		System.out.println(arr.toString());
		
		arr.removeEle(s);
		System.out.println(arr.toString());
	}
}
