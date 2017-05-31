package project.controller;

import java.io.File;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import project.my_list.MyList;

public class Read_write_file {
	public static File getDesktopFile(String name) {
		return new File(System.getProperty("user.home") + "/Desktop/" + name);
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> MyList<T> readFileJson(File file, Class<T> cl) throws Exception {
		MyList<T> items = new MyList<>();
		ObjectMapper m = new ObjectMapper();
		for (Object s : (Iterable)m.readValue(file, Object.class)) {
			Map<String, Object> sjj = (Map<String, Object>) s;
			T t = cl.newInstance();
			for (String k : sjj.keySet()) {
				Object object = sjj.get(k);
				cl.getField(k).set(t, object);
			}
			items.add(t);
		}
		return items;
	}

	public static <T> void writeFileJson(File file, MyList<T> items) throws Exception {
		ObjectMapper m = new ObjectMapper();
		m.writeValue(file, items.toList());
	}
}
