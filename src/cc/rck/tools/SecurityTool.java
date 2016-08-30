package cc.rck.tools;

import java.security.MessageDigest;

/**
 *	SecurityTool:���ڸ�������������ܡ���֤
 */
public class SecurityTool {
	//ʮ�����������ֵ��ַ���ӳ������ 
	private final static String[] hexDigits =
		{"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	
	
	/**
	 * ��inputString����MD5����(����ֱ��ʹ��compare�Ƚ�,���������ص��ַ���Ϊ��д)
	 * @param inputString ������ַ���
	 * @return MD5(inputStr):ʮ���������ô�д��ĸ��ʾ
	 */ 
	public static String MD5(String inputString){ 
		return encodeByMD5(inputString); 
	}
	
	/** 
	 * ��֤����������Ƿ���ȷ 
	 * @param inputStr ������ַ��� 
	 * @param MD5Str MD5���ܺ������ 
	 * @return ��֤���(�ѿ��ǵ�MD5Str�Ĵ�Сд����)��MD5(inputStr)==MD5Str 
	 */
	public static boolean compare(String inputStr, String MD5Str){ 
		return MD5Str.equalsIgnoreCase(encodeByMD5(inputStr));
	}
	
	/**���ַ�������MD5����*/ 
	private static String encodeByMD5(String originString){ 
		if(originString == null)return null;
		
		try{ 
			//��������ָ���㷨���Ƶ���ϢժҪ 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			//ʹ��ָ�����ֽ������ժҪ���������£�Ȼ�����ժҪ���� 
			byte[] results = md.digest(originString.getBytes()); 
			//���õ����ֽ��������ַ������� 
			String resultString = byteArrayToHexString(results); 
			return resultString.toUpperCase(); 
		}catch(Exception ex){ 
			ex.printStackTrace(); 
		}
		return null;
		 
	}
	
	/** 
	 * �ֻ��ֽ�����Ϊʮ�������ַ��� 
	 * @param b �ֽ����� 
	 * @return ʮ�������ַ��� 
	 */ 
	private static String byteArrayToHexString(byte[] b){ 
		StringBuffer resultSb = new StringBuffer(); 
		for(int i=0;i<b.length;i++){
			resultSb.append(byteToHexString(b[i])); 
		} 
		return resultSb.toString(); 
	}
	
	/** 
	 * ��һ���ֽ�ת����ʮ��������ʽ���ַ��� 
	 */ 
	private static String byteToHexString(byte b){ 
		int n = b; 
		if(n<0) 
			n=256+n; 
		int d1 = n/16; 
		int d2 = n%16; 
		return hexDigits[d1] + hexDigits[d2]; 
	}

}
