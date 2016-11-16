import com.google.code.ssm.CacheFactory
import com.google.code.ssm.config.DefaultAddressProvider
import com.google.code.ssm.providers.CacheConfiguration
import com.google.code.ssm.providers.xmemcached.MemcacheClientFactoryImpl
import com.google.code.ssm.spring.SSMCache
import com.google.code.ssm.spring.SSMCacheManager
import login.MyAuthenticationProvider;


// Place your Spring DSL code here
beans = {


	cacheConfiguration(CacheConfiguration){ consistentHashing=true }

	addressProvider(DefaultAddressProvider){ address="127.0.0.1:11211" }

	memcachedClientFactory(MemcacheClientFactoryImpl)

	cacheFactory(CacheFactory){
		cacheClientFactory=ref("memcachedClientFactory")
		addressProvider=ref("addressProvider")
		configuration=ref("cacheConfiguration")
		cacheName = "labpatologia-client-web-cache"
	}

	ssmCache(SSMCache,
			ref("cacheFactory"),
			300,
			false)

	sdCacheManager(SSMCacheManager){
		caches=[ref("ssmCache")]
	}
	
	myAuthenticationProvider(MyAuthenticationProvider) {
	}
}