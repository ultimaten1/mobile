package com.ultimate.b1_mobile_javatutorialprojects;

public class Program {
    public static final float PI = 3.14f;
    public static float TinhTong(float num1, float num2) {
        return num1 + num2;
    }

    public static String TinhTong(String text1, String text2) {
        return text1 + text2;
    }

    public static float[] TinhTong(float[] arr1, float[] arr2) {
        int length = arr1.length;
        float[] sumArr = new float[length];

        for (int i = 0; i < length; i++) {
            sumArr[i] = arr1[i] + arr2[i];
        }

        return sumArr;
    }

    public static void InMang(float[] arr) {
        for (float i : arr) {
            System.out.print(i + ",");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        System.out.println("-------------------");
        System.out.println(TinhTong(3.4f, 7.2f));
        System.out.println(TinhTong("Tran", " Thanh Dat"));
        InMang(TinhTong(new float[] {1.2f, 2.3f, 3.7f, 4.6f}, new float[] {6.3f, 2.7f, 5.2f, 9.5f}));

        VectorU v1 = new VectorU(2.4f, 3.8f, 4.6f);
        VectorU v2 = new VectorU(9.1f, 7.4f, 8.2f);
        VectorU cong = v1.CongVector(v2);
        float tVH = v1.TichVoHuong(v2);
        float m1 = v1.Module();
        float m2 = v2.Module();
        System.out.println("Vector 1: " + v1);
        System.out.println(v1 + " + " + v2 + " = " +cong );
        System.out.println(v1 + " * " + v2 + " = " + tVH );
        System.out.println("Module 1: " + v1 + " = " + m1);
        System.out.println("Module 2: " + v2+ " = " + m2 + "\n");

        Human h = new Human("Ultimate");
        Student st = new Student("Killing",8.3f);
        System.out.println(h);
        System.out.println(st);

    }
}
