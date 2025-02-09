import java.util.ArrayList;
import java.lang.reflect.Field;

public class ArrayListGrowthDemo {
    public static void main(String[] args) throws Exception {
        // 创建一个默认的ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        // 获取elementData字段的反射访问权限
        Field elementDataField = ArrayList.class.getDeclaredField("elementData");
        elementDataField.setAccessible(true);

        // 打印初始容量
        Object[] elementData = (Object[]) elementDataField.get(list);
        System.out.println("初始容量：" + elementData.length);

        // 添加元素并观察扩容
        System.out.println("\n开始添加元素...");
        for (int i = 0; i < 11; i++) {
            list.add(i);
            elementData = (Object[]) elementDataField.get(list);
            System.out.printf("添加元素 %d 后 - 容量：%d，实际元素个数：%d%n",
                    i, elementData.length, list.size());
        }

        // 演示ensureCapacity的使用
        System.out.println("\n使用ensureCapacity预分配空间...");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.ensureCapacity(20);
        elementData = (Object[]) elementDataField.get(list2);
        System.out.println("预分配后的容量：" + elementData.length);

        // 演示trimToSize的使用
        System.out.println("\n使用trimToSize收缩空间...");
        for (int i = 0; i < 5; i++) {
            list2.add(i);
        }
        elementData = (Object[]) elementDataField.get(list2);
        System.out.println("添加5个元素后 - 容量：" + elementData.length);

        list2.trimToSize();
        elementData = (Object[]) elementDataField.get(list2);
        System.out.println("调用trimToSize后 - 容量：" + elementData.length);
    }
}

