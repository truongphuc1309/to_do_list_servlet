package utils;

import java.io.BufferedReader;
import java.io.IOException;


public interface IReaderUtil {
	String toJsonString (BufferedReader reader) throws IOException;
	<T>  T reflectObject (BufferedReader reader, Class<T> model);
}
