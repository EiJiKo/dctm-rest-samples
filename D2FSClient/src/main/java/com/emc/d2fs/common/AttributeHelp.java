package com.emc.d2fs.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.emc.d2fs.models.attribute.Attribute;

/**
 * Example Attribute Helper Functions
 */
public class AttributeHelp {

	public static final String SEPARATOR_VALUE = "\u00AC";

	// STATIC Value From IDfType
	/** DfType Boolean : 0 */
	public static final int DF_BOOLEAN = 0;

	/** DfType Integer : 1 */
	public static final int DF_INTEGER = 1;

	/** DfType String : 2 */
	public static final int DF_STRING = 2;

	/** DfType Id : 3 */
	public static final int DF_ID = 3;

	/** DfType Time : 4 */
	public static final int DF_TIME = 4;

	/** DfType Double : 5 */
	public static final int DF_DOUBLE = 5;

	/** DfType Undefined : 6 */
	public static final int DF_UNDEFINED = 6;
	
	
	/**
	 *  Create String attribute 
	 * @param name String attribute name
	 * @param value String value
	 * @return Attribute
	 */
	public static Attribute createAttribute(String name, String value){
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(value);
		attr.setType(DF_STRING);
		return attr;
	}
	
	/**
	 * Create an integer attribute
	 * @param name
	 * @param intvalue
	 * @return Attribute
	 */
	public static Attribute createAttribute(String name, Integer intvalue){
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(intvalue.toString());
		attr.setType(DF_INTEGER);
		return attr;
	}

	/**
	 * Create an long attribute
	 * @param name
	 * @param longvalue
	 * @return Attribute
	 */
	public static Attribute createAttribute(String name, Long longvalue){
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(longvalue.toString());
		attr.setType(DF_INTEGER);
		return attr;
	}
	
	/**
	 * Create boolean attribute
	 * @param name String attribute name
	 * @param value Boolean value
	 * @return Attribute
	 */
	public static Attribute createAttribute(String name, Boolean value){
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(value.toString());
		attr.setType(DF_BOOLEAN);
		return attr;
	}
	
	/**
	 * Create String attribute containing a list separated by SEPARATOR_VALUE
	 * @param name String attribute name
	 * @param values String[] of values
	 * @return Attribute
	 */
	public static Attribute createAttribute(String name, String[] values){
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(join(values, SEPARATOR_VALUE));
		attr.setType(DF_STRING);
		return attr;
	}

	public static Attribute createAttribute(String name, String sValue,
			int dfId) {
		Attribute attr=new Attribute();
		attr.setName(name);
		attr.setValue(sValue);
		attr.setType(dfId);
		return attr;
	}
	
	public static String join(List<String> list, String separator)
	{
	    StringBuffer result = new StringBuffer();
	    int i=0;
		for (String str: list)
	    {
	        if (i++ != 0)
	            result.append(separator);
	        result.append(str);
	    }
	    return result.toString();
    }
    protected static String join(String[] array, String separator)
    {
        StringBuffer result = new StringBuffer();
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            if (i != 0)
                result.append(separator);
            result.append(array[i]);
        }
        return result.toString();
    }
    
    /**
     *  Remove attributes not named in "keepnames" array.
     * @param attributes
     * @param names
     * @return
     */
    public static void keepAttributes(List<Attribute> attributes, String[] keepnames) {
    	List<String> names =  Arrays.asList(keepnames);
    	
    	for(int i=attributes.size()-1; i>=0; i--){
    		Attribute attr = attributes.get(i);
    		if (!names.contains(attr.getName())){
    			System.out.println(" removeAttributes: "+attr.getName());
    			attributes.remove(i);
    		}
    	}
    }
    
    /**
     * Get attribute by name from list.
     * @param attributes
     * @return
     */
    public static Attribute getAttribute(List<Attribute> attributes, String name) {
    	for(Attribute attr: attributes){
    		if (attr.getName().equals(name))
    			return attr;
    	}
    	return null;
    }
    /**
     * Get string attribute from list, return defaultValue if not found or EMPTY.
     * @param attributes
     * @param name
     * @param defaultValue
     * @return
     */
    public static String getStringValue(List<Attribute> attributes, String name, String defaultValue) {
    	Attribute attr = getAttribute(attributes, name);
    	if (attr!=null){
    		if (attr.getValue()!=null && attr.getValue().length()>0)
    			return attr.getValue();
    	}
    	return defaultValue;
    }
    /**
     * Get string attribute from list, return defaultValue if not found or EMPTY.
     * @param attributes
     * @param name
     * @param defaultValue
     * @return
     */
    public static Boolean getBooleanValue(List<Attribute> attributes, String name, Boolean defaultValue) {
    	Attribute attr = getAttribute(attributes, name);
    	if (attr!=null){
    		if (attr.getValue()!=null && attr.getValue().length()>0)
    			return Boolean.parseBoolean(attr.getValue());
    	}
    	return defaultValue;
    }

    /**
     * Get a list of attribute names
     * @param attributes
     * @return
     */
    public static List<String> getAttributeNames(List<Attribute> attributes) {
		List<String> names = new ArrayList<String>();
		for (Attribute attr: attributes){
			names.add(attr.getName());
		}
		return names;
	}


}
