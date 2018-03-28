package org.sgooty.hive.hiveUDF;

import org.junit.Test;
import static org.junit.Assert.assertEquals; 


public class AddKeyValueToJSONTest  {
	
	@Test
	public void TestAddKeyValueJson(){ 
		AddKeyValueToJSON jsonUDF = new AddKeyValueToJSON(); 
		assertEquals("{\"key\":\"value\"}", jsonUDF.evaluate("{}", "key", "value"));
		assertEquals("{\"key\":\"value\",\"key1\":\"value1\"}", jsonUDF.evaluate("{\"key\":\"value\"}", "key1", "value1"));
		assertEquals("{\"key\":\"value\"}", jsonUDF.evaluate("{\"key\":\"value\"}", "key", "value"));

		

		
	}
	


}
