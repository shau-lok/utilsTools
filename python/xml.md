
# xml 的处理

## 1. 解析xml

xml_data

```
<Response>
    <Body>
        <Result>
            <ResultCode>success</ResultCode>
            <ErrorMsg></ErrorMsg>
        </Result>
        <OrderID>3u3</OrderID>
        <ImmediateConfirm>0</ImmediateConfirm>
        <IsAutoWithhold>1</IsAutoWithhold>
        <AutoWithholdState>1</AutoWithholdState>
        <CreditBalance>999999999.0</CreditBalance>
    </Body>
</Response>
```

### xmldict

> 将标准xml格式还原成dict字典

```
import xmldict

xml_dict = xmldict.xml_to_dict(xml_data)
```

### untangle

> 将XML文档映射为一个Python 对象

```
import untangle
obj = untangle.parse(xml_data)

# 获取child节点
obj.response.body.result.resultCode.cdata == 'success'
obj.response.body.result.ErrorMsg.cdata == ''


<root>
    <child name="child1">
</root>

obj.root.child['name'] == 'child1'
```

### xmltodict

> 将xml变得像json

```
import xmltodict

obj = xmltodict.parse(xml_data)


<mydocument has="an attribute">
  <and>
    <many>elements</many>
    <many>more elements</many>
  </and>
  <plus a="complex">
    element as well
  </plus>
</mydocument>

doc['mydocument']['@has'] # == u'an attribute'
doc['mydocument']['and']['many'] # == [u'elements', u'more elements']
doc['mydocument']['plus']['@a'] # == u'complex'
doc['mydocument']['plus']['#text'] # == u'element as well'
```













