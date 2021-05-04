import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashMethod
{
    public static void main(String[] args) {
        try
        {
            File file1= new File("c:/Users/Sharmina/workspace/Sha_file/src/shattered-1.pdf");
            File file2= new File("c:/Users/Sharmina/workspace/Sha_file/src/shattered-2.pdf");
            String shaHash1 = getHashFile(file1);
            String shaHash2 = getHashFile(file2);
            System.out.println("shattered-1 file's Hash is : " + shaHash1);
            System.out.println("shattered-2 file's Hash is : " + shaHash2);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private static String getHashFile(File file) throws IOException
    {
        try
        {
            MessageDigest shaDigest = MessageDigest.getInstance("SHA1");
            FileInputStream fileInput = new FileInputStream(file);
            byte[] hashArray = new byte[1024];

            int byteCount=0;
            while ((byteCount = fileInput.read(hashArray)) != -1)
            {
                shaDigest.update(hashArray, 0, byteCount);
            };
            byte[] bytes= shaDigest.digest();

            StringBuffer result=new StringBuffer((""));
            for(int i=0; i< bytes.length ;i++)
            {
                result.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return result.toString();
        }
        catch (NoSuchAlgorithmException ex)
        {
            throw new RuntimeException(ex);
        }
    }
}
