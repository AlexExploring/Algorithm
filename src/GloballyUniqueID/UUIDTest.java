package GloballyUniqueID;

import java.util.UUID;

public class UUIDTest {
    public static void main(String[] args) {
        //��ȡһ���汾4��������ֽ������UUID��
        UUID randomUUID = UUID.randomUUID();
        System.out.println(randomUUID.toString().replaceAll("-",""));

        //��ȡһ���汾3(��������)����ָ�����ֽ������UUID��
        byte[] nbyte = {10, 20, 30};
        UUID uuidFromBytes = UUID.nameUUIDFromBytes(nbyte);
        System.out.println(uuidFromBytes.toString().replaceAll("-",""));
    }


}
