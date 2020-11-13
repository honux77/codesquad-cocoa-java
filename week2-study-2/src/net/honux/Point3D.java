package net.honux;

public class Point3D extends Point {
    public int z;

    public Point3D(int x, int y, int v, int z) {
        super(x, y, v);
        this.z = z;
    }

    // final 메소드를 상속받으면 컴파일 에러가 납니다!
//    @Override
//    public void sayPos() {
//        super.sayPos();
//        System.out.println(z);
//    }
}
