/**
 * 
 */
package com.example.exceptions;

import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;

/**
 * @author mahesh.srinivas
 *
 */
public class CustomCacheErrorHandler implements CacheErrorHandler {


	/* (non-Javadoc)
	 * @see org.springframework.cache.interceptor.CacheErrorHandler#handleCacheClearError(java.lang.RuntimeException, org.springframework.cache.Cache)
	 */
	@Override
	public void handleCacheClearError(RuntimeException arg0, Cache arg1) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.interceptor.CacheErrorHandler#handleCacheEvictError(java.lang.RuntimeException, org.springframework.cache.Cache, java.lang.Object)
	 */
	@Override
	public void handleCacheEvictError(RuntimeException arg0, Cache arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.interceptor.CacheErrorHandler#handleCacheGetError(java.lang.RuntimeException, org.springframework.cache.Cache, java.lang.Object)
	 */
	@Override
	public void handleCacheGetError(RuntimeException arg0, Cache arg1, Object arg2) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.interceptor.CacheErrorHandler#handleCachePutError(java.lang.RuntimeException, org.springframework.cache.Cache, java.lang.Object, java.lang.Object)
	 */
	@Override
	public void handleCachePutError(RuntimeException arg0, Cache arg1, Object arg2, Object arg3) {
		// TODO Auto-generated method stub

	}

}
