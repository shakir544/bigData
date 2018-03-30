package org.sgooty.hive.hiveUDF;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;


@Description(name = "timestamptoepoch",
    value = "_FUNC_(str, str) - Convert a String timestamp with a format"
		+ " \"yyyy-MM-dd'T'HH:mm:ss.SSSZ\" to epoch time as a millisecond long",
    extended = "Example:\n" +
    "  > SELECT timestamptoepoch(timestamp) FROM test_database;"
)
/**
 * 
 * @author Shakir Gooty
 * Hive User defined function to convert the time stamp to epoc in milli seconds.
 */
public class TimeStampToEpoc extends UDF{ 
    /**
     * Convert a String timestamp with a format "yyyy-MM-dd'T'HH:mm:ss.SSSZ" to epoch time as a millisecond long	 * 
     * @param timeStamp
     * @return
     */
     public Long evaluate(String timeStamp){ 
        if(timeStamp == null){ 
           return null; 
        }
		try{ 
			return javax.xml.bind.DatatypeConverter.parseDateTime(timeStamp).getTimeInMillis();
		}catch(Exception e){ 
			e.printStackTrace();
		}
		return null; 
	}
}
