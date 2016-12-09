package mapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;

public class MyBatisCache implements Cache {
	private Map<Object,Object> cache=new HashMap<Object,Object>();
	private String id;
	public MyBatisCache(String id){
		System.out.println("id:"+id);
		this.id=id;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void putObject(Object key, Object value) {
		// TODO Auto-generated method stub
		System.out.println("key:"+key);
		System.out.println("value:"+value);
		cache.put(key, value);

	}

	@Override
	public Object getObject(Object key) {
		// TODO Auto-generated method stub
		return cache.get(key);
	}

	@Override
	public Object removeObject(Object key) {
		// TODO Auto-generated method stub
		return cache.remove(key);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		cache.clear();
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return cache.size();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

}
