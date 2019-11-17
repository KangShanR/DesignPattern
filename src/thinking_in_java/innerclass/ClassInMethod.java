package thinking_in_java.innerclass;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.function.Predicate;

/**
 * 方法、域内的类
 * @author KangShan
 * @date 2019/11/18 0:26
 */
@NoArgsConstructor
public class ClassInMethod {
    @Setter
    int i;

    Predicate s = r -> false;

    ClassInMethod(int i){
        System.out.println(i);
        this.i = i;
    }

    public TestInterface test2(String s) {
        return new TestInterface(){
            @Override
            public void greet() {

            }

            private  String str;
            {
                str = s;
            }
        };
    }

    void test(){
        class PartClass implements TestInterface{
            @Override
            public void greet() {
                System.out.println("part class greet...");
            }
        }
        System.out.println(new PartClass());
    }

    public static void main(String[] args) {
//        new ClassInMethod().test();
        /**
         * a anonymous class for interface
         */
//        new TestInterface(){
//            @Override
//            public void greet() {
//                System.out.println("new test interface then let it greet:");
//            }{
//                greet();
//            }
//        };


        /**
         * anonymous object
         */
        System.out.println(new ClassInMethod(4){
            @Override
            public void setI(int i){
                System.out.println("now, parameter i = "+ i);
                this.i = 100;
                System.out.println("now, this i = "+this.i);
            }
            {
                setI(0);
            }
        }.i);
    }
}
