package net.honux;

public class Point3D extends Point {
    public int z;

    public Point3D(int x, int y, int v, int z) {
        super(x, y, v);
        this.z = z;
    }

    // final 메소드를 상속받으면 에러입니다!
//    @Override
//    public void sayPos() {
//        super.sayPos();
//        System.out.println(z);
//    }
}
