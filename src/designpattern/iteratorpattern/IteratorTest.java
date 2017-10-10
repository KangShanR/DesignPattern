package designpattern.iteratorpattern;

import designpattern.iteratorpattern.Repository.DoIterator;

public class IteratorTest {

	public static void main(String[] args) {
		Repository rep = new Repository();
		DoIterator ite2 = rep.new DoIterator();
		for(Iterator iter = new Repository().getIterator();iter.hasNext();){
			String ele = (String)iter.next();
			System.out.println(ele);
		}
	}
}
