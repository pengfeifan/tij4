package com.github.tij4.chap12;

class DynamicFieldsException extends Exception{
}
// 异常链
public class DynamicFields {

	private Object[][] fields;
	public DynamicFields(int initialSize){
		fields = new Object[initialSize][2];
		for(int i = 0;i<initialSize;i++){
			fields[i] = new Object[]{null,null};
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		for(Object[] obj:fields){
			result.append(obj[0]);
			result.append(":");
			result.append(obj[1]);
			result.append("\n");
		}
		return result.toString();
	}
	
	private int hasField(String id){
		for(int i=0;i<fields.length;i++){
			if(id.equals(fields[i][0])){
				return i;
			}
		}
		return -1;
	}
	
	private int getFieldNumber(String id) throws NoSuchFieldException{
		int fieldNumber = hasField(id);
		if(fieldNumber == -1){
			throw new NoSuchFieldException();
		}
		return fieldNumber;
	}
	
	private int makeField(String id){
		for(int i=0;i<fields.length;i++){
			if(fields[i][0] == null){
				fields[i][0] = id;
				return i;
			}
		}
		
		Object[][] tmp = new Object[fields.length+1][2];
		for(int i=0;i<fields.length;i++){
			tmp[i]=fields[i];
		}
		for(int i=fields.length;i<tmp.length;i++){
			tmp[i] = new Object[]{null,null};
		}
		fields=tmp;
		return makeField(id);
	}
	
	public Object getField(String id) throws NoSuchFieldException{
		return fields[getFieldNumber(id)][1];
	}
	
	public Object setField(String id,Object value) throws DynamicFieldsException{
		if(value == null){
			DynamicFieldsException dfe = new DynamicFieldsException();
			dfe.initCause(new NullPointerException());//Caused by: java.lang.NullPointerException
			throw dfe;//
		}
		int fieldNumber = hasField(id);
		if(fieldNumber == -1)
			fieldNumber = makeField(id);
		Object result = null;
		try{
			result = getField(id);
		}catch(NoSuchFieldException e){
			throw new RuntimeException(e);
		}
		fields[fieldNumber][1] = value;
		return result;
	}
	
	public static void main(String[] paramters){
		DynamicFields df = new DynamicFields(3);
		System.out.println(df);
		try{
			df.setField("d","a value of d");
			df.setField("number",55);
			df.setField("Number2", 35);
			System.out.println("df1:"+df);
			df.setField("d", "a new value of d");
			df.setField("number3", 45);
			System.out.println("df2:"+df);
			System.out.println("df.getField(\"d\"):"+df.getField("d"));
			Object field = df.setField("d", null);
		}catch(NoSuchFieldException e){
			e.printStackTrace(System.out);
		}catch(DynamicFieldsException e){
			e.printStackTrace(System.err);
		}
	}
	/**
null:null
null:null
null:null

df1:d:a value of d
number:55
Number2:35

df2:d:a new value of d
number:55
Number2:35
number3:45

df.getField("d"):a new value of d
com.github.tij4.chap12.DynamicFieldsException
	at com.github.tij4.chap12.DynamicFields.setField(DynamicFields.java:69)
	at com.github.tij4.chap12.DynamicFields.main(DynamicFields.java:98)
Caused by: java.lang.NullPointerException
	at com.github.tij4.chap12.DynamicFields.setField(DynamicFields.java:70)
	... 1 more
	 */
}





















