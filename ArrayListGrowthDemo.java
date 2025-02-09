package ArrayListDemo;

import java.util.ArrayList;

public class ArrayListGrowthDemo {
    public static void main(String[] args) {
        // 1. 演示默认构造的ArrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        System.out.println("1. 默认构造的ArrayList:");
        System.out.println("初始size: " + list1.size());

        // 添加元素观察容量变化（通过size和toString间接观察）
        for (int i = 0; i < 11; i++) {
            list1.add(i);
            System.out.printf("添加元素 %d 后 - size：%d，内容：%s%n",
                    i, list1.size(), list1.toString());
        }

        // 2. 演示指定初始容量
        System.out.println("\n2. 指定初始容量的ArrayList:");
        ArrayList<Integer> list2 = new ArrayList<>(5);
        System.out.println("初始size: " + list2.size());

        // 添加超过初始容量的元素
        for (int i = 0; i < 6; i++) {
            list2.add(i);
            System.out.printf("添加元素 %d 后 - size：%d，内容：%s%n",
                    i, list2.size(), list2.toString());
        }

        // 3. 演示ensureCapacity
        System.out.println("\n3. 使用ensureCapacity:");
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.ensureCapacity(20); // 预分配空间
        System.out.println("调用ensureCapacity(20)后 size: " + list3.size());

        // 4. 演示trimToSize
        System.out.println("\n4. 使用trimToSize:");
        ArrayList<Integer> list4 = new ArrayList<>(10);
        for (int i = 0; i < 5; i++) {
            list4.add(i);
        }
        System.out.println("添加5个元素后 size: " + list4.size());
        list4.trimToSize();
        System.out.println("调用trimToSize()后 size: " + list4.size());
    }
}
