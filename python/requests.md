
# Requests - Python

get请求
```
r = requests.get('https://api.github.com/events')
```

post请求
```
 r = requests.post('http://httpbin.org/post', data = {'key':'value'})
```

各种请求方式
```
>>> r = requests.put('http://httpbin.org/put', data = {'key':'value'})
>>> r = requests.delete('http://httpbin.org/delete')
>>> r = requests.head('http://httpbin.org/get')
>>> r = requests.options('http://httpbin.org/get')
```

url后边加参数请求
```
>>> payload = {'key1': 'value1', 'key2': 'value2'}
>>> r = requests.get('http://httpbin.org/get', params=payload)
```

session

```python
session = Session()
req = Request(method, url, cookies=session.cookies, **kwargs)
prepped = req.prepare()
resp = session.send(prepped, verify=False, proxies=proxies, timeout=15)

resp.text
resp.cookies
resp.status_code
resp.history (如果302跳转的话，就有个跳转历史)

# 自定义增加cookies
resp.cookies['kxkskks'] = 'sdkjsd'

```

