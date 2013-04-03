package reflection.tut;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassTUT {

	public static void main(String[] args) throws Exception {

		//getting the class instance..
		Class instance1 = TestClass.class;
		System.out.println("instance1 = " + instance1);

		Class instance2 = Class.forName("reflection.tut.TestClass");
		System.out.println("instance2 = " + instance2);

		//getting the name of the class
		//fully qualified name..
		System.out.println("instance1 NAME = " + instance1.getName());
		//simple name..
		System.out.println("instance1 NAME = " + instance1.getSimpleName());

		//accessing the modifiers
		int modifier = instance1.getModifiers();
		System.out.println("Modifier = " + Modifier.isPublic(modifier));

		//accessing the package info
		Package package1 = instance1.getPackage();
		System.out.println("package  = " + package1.getName());

		//accessing the super class 
		Class superclass = instance1.getSuperclass();
		System.out.println("superclass = " + superclass);

		//accessing the interface info
		Class[] interfaces = instance1.getInterfaces();
		for (int i = 0; i < interfaces.length; i++) {
			System.out.println("interface = " + interfaces[i]);
		}

		//accessing the constructors, Methods, Fields

		//accessing the constructors
		Constructor[] constructors = instance1.getConstructors();
		for (int i = 0; i < constructors.length; i++) {
			System.out.println("constructors = " + constructors[i]);
		}
		//accessing the parameters of a constructor
		Class[] parameterTypes = constructors[0].getParameterTypes();
		for (int i = 0; i < parameterTypes.length; i++) {
			System.out.println("constructor parameterTypes = " + parameterTypes[i]);
		}

		//creating an instance using the constructor
		TestClass instance3 = (TestClass) constructors[0].newInstance(10, 10);
		System.out.println("ClassTUT.main()" + instance3.getX());

		Method[] methods = instance1.getMethods();
		for (int i = 0; i < methods.length; i++) {
			System.out.println("methods = " + methods[i]);
		}

		Field[] fields = instance1.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println("fields = " + fields[i]);
		}

		//printing the getters and setters..
		new ClassTUT().printGettersSetters(instance1);

		//accessing the private fields
		//Despite the common belief it is actually possible to access private fields and methods of other classes via Java Reflection. 
		//It is not even that difficult. This can be very handy during unit testing. This text will show you how.
		Field privateStringField = TestClass.class.getDeclaredField("res");
		privateStringField.setAccessible(true);
		System.out.println("PRIVATE FIELD NAME = " + privateStringField.getName());

		//creating arrays

		int[] intArray = (int[]) Array.newInstance(int.class, 3);
		Array.set(intArray, 0, 123);
		Array.set(intArray, 1, 456);
		Array.set(intArray, 2, 789);

		System.out.println("intArray[0] = " + Array.get(intArray, 0));
		System.out.println("intArray[1] = " + Array.get(intArray, 1));
		System.out.println("intArray[2] = " + Array.get(intArray, 2));

		//As a side note, you cannot obtain the class object of primitives using Class.forName(). 
		//Both of the examples below result in a ClassNotFoundException:

		Class intClass1 = Class.forName("I");
		Class intClass2 = Class.forName("int");

	}

	public static void printGettersSetters(Class aClass) {
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			if (isGetter(method)) System.out.println("getter: " + method);
			if (isSetter(method)) System.out.println("setter: " + method);
		}
	}

	public static boolean isGetter(Method method) {
		if (!method.getName().startsWith("get")) return false;
		if (method.getParameterTypes().length != 0) return false;
		if (void.class.equals(method.getReturnType())) return false;
		return true;
	}

	public static boolean isSetter(Method method) {
		if (!method.getName().startsWith("set")) return false;
		if (method.getParameterTypes().length != 1) return false;
		return true;
	}

}
