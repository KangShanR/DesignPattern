package thinking_in_java;

/**
 * 父包级修辞符测试：
 * 结果: 包之间并不存在着父子继承关系，在父包并不能直接访问子包元素
 * @author KangShan
 * @date 2019/10/29 23:45
 */
public class AccessTest {
    public static void main(String[] args){
        AccessTest accessTest = new AccessTest();
//        System.out.println(thinking_in_java.access_control.AccessTest.C);
    }
}
