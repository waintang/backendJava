public class Main {
    public static void main(String[] args) {
        String h1=new String("22")+new String("1");//�� 22��1��221����-�����أ���jdk6ʱ,22��1���ַ�����jdk7ʱ,��22��1�������ã�
        h1.intern();// ��221��Ӹ� �����أ���jdk6ʱ��221�ַ����������أ�jdk7ʱ����221�������ø������أ�
        String h2="221"; // ��ʱ����������221�����ǣ�h2��jdk6ָ������221�ַ��������ã�jdk7���ɳ�����ָ���221�ַ��������� ��

        System.out.println("h1��h2 ���õ�ַ�Ƿ���ͬ��"+(h1 == h2));//result��jdk6 false��jdk7 true
        System.out.println("h1��h2 ֵ�Ƿ���ͬ��"+h1.equals(h2));//result��true
    }
}
