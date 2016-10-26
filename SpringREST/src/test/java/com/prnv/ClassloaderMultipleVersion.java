package com.prnv;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassloaderMultipleVersion {

	public static void main(String[] args) throws Exception {

		ClassLoader loaderA = new URLClassLoader(new URL[] { new File("C:\\Users\\\\Desktop\\Hellov1.jar")
																.toURI().toURL() });
		ClassLoader loaderB = new URLClassLoader(new URL[] { new File("C:\\Users\\\\Desktop\\Hellov2.jar")
																.toURI().toURL() });

		Class<?> classA = loaderA.loadClass("com.prnv.hello.Hello");
		Class<?> classB = loaderB.loadClass("com.prnv.hello.Hello");

		Method methodA = classA.getDeclaredMethod("hello");
		Method methodB = classB.getDeclaredMethod("hello");

		System.out.println(methodA.invoke(classA.newInstance()));
		System.out.println(methodB.invoke(classB.newInstance()));
		
	    //ElasticSearchInterface es1 = (ElasticSearchInterface) c1.newInstance();
		//es1.search(null); // Queries ElasticSearch1.x

	}

}
