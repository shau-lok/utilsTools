
# sqlite数据库

### DELETE操作

```sql
DELETE FROM OrderData WHERE OrderData.Order_ID IN
(SELECT OrderInfo.Order_ID
FROM OrderInfo
JOIN CustData on OrderData.Order_ID = OrderInfo.Order_ID
WHERE CustData.Bus_Name = 'Albertsons')
```

```sql
String whereClause = Tables.AdwordsHistoryTable.SITENAME + "='" + items.sitename + "' and " + Tables.AdwordsHistoryTable.CITY + "='" + city + "'";
           database.delete(CityDBHelper.ADWORDS_HISTORY_TABLE, whereClause, null);
```
