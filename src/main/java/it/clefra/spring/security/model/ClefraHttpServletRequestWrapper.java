package it.clefra.spring.security.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author <a href="mailto:francesco.mirenda@finconsgroup.com">Francesco L Mirenda</a>
 *
 */
public class ClefraHttpServletRequestWrapper extends HttpServletRequestWrapper{
	public static final String AUTHORIZATION_HEADER_NAME = "UserId";

	private Map<String, List<String>> headers = new HashMap<String, List<String>>();
	private String userId;

	public ClefraHttpServletRequestWrapper(HttpServletRequest request, String userId) {
		super(request);
		this.userId = userId;
	}

	@Override
	public String getHeader(String name) {
		if (headers.containsKey(name)) {
			return headers.get(name).get(0);
		}

		return super.getHeader(name);
	}

	public String[] getHeaderValues(String name){
		if (headers.containsKey(name)) {
			return headers.get(name).toArray(new String[0]);
		} else {
			return null;
		}

	}

	public void addHeader(String header, String value) {
		List<String> list = headers.get(header);
		if (list == null) {
			list = new ArrayList<String>();
			headers.put(header, list);
		}
		list.add(value);
	}

	public void setHeader(String header, String value) {
		List<String> list = new ArrayList<String>();
		headers.put(header, list);
		list.add(value);
	}

	public Enumeration<String> getHeaderNames() {
		List<String> list = new ArrayList<String>();

		HttpServletRequest request = (HttpServletRequest) getRequest();
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			list.add(e.nextElement());
		}

		list.addAll(headers.keySet());

		return Collections.enumeration(list);
	}

	@Override
	public Enumeration<String> getHeaders(String name) {
		List<String> list = new ArrayList<String>();

		HttpServletRequest request = (HttpServletRequest) getRequest();
		if (headers.containsKey(name)) {
			list.add(headers.get(name).get(0));
		}

		return Collections.enumeration(list);
	}

}
