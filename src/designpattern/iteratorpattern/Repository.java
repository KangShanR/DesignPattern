package designpattern.iteratorpattern;

public class Repository implements Container {

	String elements[] = {"kfc","jfk","mcd"};
	
	/**
	 * 返回内部类的对象，注意这儿的依赖倒置
	 */
	@Override
	public Iterator getIterator() {
		return new DoIterator();
	}

	/**
	 * 内部类，实现迭代器接口
	 * @author Administrator
	 *
	 */
	public class DoIterator implements Iterator{
		
		int index;
		
		/**
		 * 判定索引是否指向在集合之中，如果还在就返加true
		 */
		@Override
		public boolean hasNext() {
			if(index < elements.length)
				return true;
			return false;
		}

		/**
		 * 实现迭代器核心算法，如果后面还有元素就返回这个元素，最后的结果就是index会与集合的长度相等，索引指向最后的一个的后面
		 */
		@Override
		public Object next() {
			if(this.hasNext()){
				Object obj = elements[index++];
				return obj;
			}
			return null;
		}
	}
}
