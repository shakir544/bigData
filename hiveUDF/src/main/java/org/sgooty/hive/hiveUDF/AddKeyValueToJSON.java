package org.sgooty.hive.hiveUDF;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;
import org.sgooty.JSONUtils.*;


@Description(
		  name = "addkeyvaluetojson",
		  value = "_FUNC_(str, str, str) - return a JSON string with an additional key/value pair included",
		  extended = "Example:\n" +
		  "  > SELECT addkeyvaluetojsonstring(json, \"key1\", \"key2\") FROM dual a;\n"
		)
public class AddKeyValueToJSON extends UDF{

	public String evaluate(String jsonString, String key, String value){ 
		if(jsonString == null || key == null || value == null ){ 
			return null; 
		}
		return JSONUtils.addKeyValueToJSONString(jsonString,key,value);
	}
}
