# ESunBankDemo  
## 員工座位管理系統

本專案為人力資源部門設計之員工座位管理系統，旨在提升各樓層座位配置的管理效率與靈活性，提供即時且直觀的座位資訊展示與調整功能。
本專案實作:設計一套具備 視覺化座位圖、即時互動操作 及 資料庫同步更新 的管理介面，有效提升座位管理效率與準確性。

---

## 主要功能

1. **座位狀態展示**  
   - 即時從資料庫讀取各樓層座位資訊  
   - 以色彩區分空位與已佔用座位，已佔用座位同時顯示對應員工編號  

2. **座位分配與調整**  
   - 嚴格限制每位員工僅能佔用一個座位  
   - 透過下拉選單選擇目標員工（員工編號固定5碼）  
   - 選擇員工後點擊空座位，即完成座位預選並以指定顏色標示  
   - 已佔用座位可點擊清除，釋放該座位成為空位  
   - 點擊「送出」按鈕後，將座位調整結果同步更新至資料庫  

---

## 技術架構

- **前端**：使用 Angular 框架，實現動態且響應式的座位顯示與互動介面  
- **後端**：採用 Spring Boot 框架，負責實作 RESTful API，處理座位及員工資料管理  
- **資料庫**：MySQL，儲存員工與座位資料，確保資料一致性與安全性  

---

## 使用說明

1. 啟動系統並進入首頁，瀏覽各樓層座位狀態  
2. 從下拉選單選擇欲調整座位的員工  
3. 點擊空座位完成分配，或點擊已佔用座位以釋放  
4. 完成調整後，點擊右下角「送出」按鈕，將變更保存至資料庫  

---

## 注意事項

- 員工編號格式嚴格限制為固定5碼  
- 每位員工僅允許分配一個座位，系統會自動檢核避免重複分配  
- 若欲分配座位已被他人佔用，系統將彈出提示訊息  
- 當未選擇員工且座位已被佔用時，系統會詢問是否清除該座位的佔用紀錄  

---

## 聯繫我
若您對本專案有任何問題、建議或交流意願，歡迎透過以下方式與我聯繫：
Email：Baoyungpeng1999@gmail.com

---

## 如何啟動 Angular 專案

- 下載本專案至本地路徑（如：C:\...\ESunBankDemo\E_Sun_seatingManagement）
- 使用命令提示字元（cmd）或終端機進入專案目錄
- 執行以下指令安裝所有依賴套件
- npm install
- 系統會自動詢問樣式格式，請選擇 SCSS
- 開啟專案: ng serve || ng s
- 開啟新專案: ng serve open || ng s -o

---

## 前端 Angular 專案目錄結構 E_Sun_seatingManagement 樹狀架構圖
```
E_Sun_seatingManagement/
├── .angular/                  # Angular CLI 自動產生的暫存資料（建構過程用）
├── .vscode/                   # Visual Studio Code 編輯器的專案設定
├── node_modules/              # 專案依賴的 npm 套件
├── public/                    # 公用靜態資源（若有）
├── src/                       # 專案主要開發來源目錄
│   └── app/                   # Angular 應用的主模組資料夾
│       ├── @models/           # 定義資料模型（TypeScript interfaces 或 classes）
│       │   ├── employee.model.ts     # 員工資料模型
│       │   └── seat.model.ts         # 座位資料模型
│
│       ├── @services/         # 提供商業邏輯與資料請求的服務
│       │   ├── employee.service.ts   # 員工相關資料的服務層邏輯
│       │   └── seat.service.ts       # 座位相關資料的服務層邏輯
│
│       ├── seating-chart/     # 座位圖元件（Component）
│       │   ├── seating-chart.component.html   # HTML 模板
│       │   ├── seating-chart.component.scss   # 樣式檔
│       │   └── seating-chart.component.ts     # TypeScript 元件邏輯
│
│       ├── app.component.html         # 主元件的 HTML 模板
│       ├── app.component.scss         # 主元件的樣式
│       ├── app.component.spec.ts      # 主元件的單元測試檔案
│       ├── app.component.ts           # 主元件的邏輯與生命週期管理
│       ├── app.config.ts              # 全域設定檔（若有用到）
│       └── app.routes.ts              # Angular 的路由設定檔
│
├── index.html                 # 應用程式的入口 HTML
├── main.ts                    # Angular 應用的啟動入口點
├── styles.scss                # 全域樣式設定
└── tsconfig.json              # TypeScript 編譯器設定檔
```
---

## 後端 Spring Boot 專案目錄結構 E.SUN-BANK_project 樹狀架構圖

E.SUN_BANK_project/
└── src/
    └── main/
        ├── java/
        │   └── com.example.E.SUN_BANK_project/
        │       ├── Application.java                 # Spring Boot 啟動入口
        │
        │       ├── config/                          # 配置相關類別（尚未顯示內容）
        │
        │       ├── constants/                       # 常數定義
        │       │   └── ResMessage.java              # 回應訊息文字設定
        │
        │       ├── controller/                      # 控制層：接收前端請求
        │       │   ├── EmployeeController.java
        │       │   └── SeatChartController.java
        │
        │       ├── dao/                             # 資料存取層
        │       │   ├── EmployeeDao.java
        │       │   └── SeatingChartDao.java
        │
        │       ├── entity/                          # 資料實體（對應資料庫表）
        │       │   ├── Employee.java
        │       │   └── SeatingChart.java
        │
        │       ├── ifs/                             # Service 介面（interface）
        │       │   ├── EmployeeService.java
        │       │   └── SeatChartService.java
        │
        │       ├── impl/                            # Service 實作類別
        │       │   ├── EmployeeServiceImpl.java
        │       │   └── SeatChartServiceImpl.java
        │
        │       └── vo/                              # View Object / 請求與回應封裝物件
        │           ├── BasicRes.java
        │           ├── ClearEmpSeatReq.java
        │           ├── EmployeeReq.java
        │           ├── GetAllEmployeeRes.java
        │           └── GetAllRes.java
        │
        └── resources/
            └── application.properties               # Spring Boot 設定檔
