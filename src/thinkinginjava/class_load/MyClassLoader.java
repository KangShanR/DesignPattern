package thinkinginjava.class_load;

import java.io.*;

/**
 * @author KangShan
 * @date 2019/11/4 19:19
 */
public class MyClassLoader extends ClassLoader {
    String classPath;

    MyClassLoader(String classPath){
        super(ClassLoader.getSystemClassLoader());
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) {
        name = name.replace(".", "//");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream = new FileInputStream(new File(classPath + name + ".class"))) {
            int i = 0;
            while((i = fileInputStream.read()) != -1){
                byteArrayOutputStream.write(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = byteArrayOutputStream.toByteArray();
        return super.defineClass(name, bytes, 0, bytes.length);
    }
}
