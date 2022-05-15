## 服務描述

1. 呼叫 coindesk API
2. 查詢 / 新增 / 修改 / 刪除 各幣別中英對照表

## API說明
### Base URL : http://localhost:9100
| 說明 | Method | path | 參數 | 回傳範例 |
| :--: | :------: | :----:| :--: | :----: |
| 查詢單一幣別對應資料 | Get | /CurrencyChinese/search | 幣別(code) | <img width="160" alt="image" src="https://user-images.githubusercontent.com/43576628/168458846-9be98112-6294-4624-8d99-587343230734.png"> |
| 查詢所有幣別對應資料 | Get | /CurrencyChinese/search | 無 | <img width="160" alt="image" src="https://user-images.githubusercontent.com/43576628/168458846-9be98112-6294-4624-8d99-587343230734.png"> |
| 新增幣別對應資料 | Post | /CurrencyChinese/ | [{"currency" : "幣別(code)", "chinese" : "幣別(中文)"}]| 無 |
| 更新單一幣別對應資料 | Put | /CurrencyChinese/update | {"currency" : "幣別(code)", "chinese" : "幣別(中文)"} |<img width="134" alt="image" src="https://user-images.githubusercontent.com/43576628/168458919-cb9b75cf-ec1c-46ef-856a-445d4776900a.png"> |
| 刪除單一幣別對應資料 | Delete | /CurrencyChinese/search | 幣別(code) | 無 |
| 呼叫 coindesk API | Get | /api/callCoindesk | 無 | <img width="829" alt="image" src="https://user-images.githubusercontent.com/43576628/168459033-8bcf056f-79af-4a73-b83d-fa6e4de34700.png"> |
| 呼叫資料轉換的 API | Get | /api/rebuild | 無 | <img width="215" alt="image" src="https://user-images.githubusercontent.com/43576628/168459062-88575b66-99fd-4ecd-ac63-49d71c82c545.png"> |
