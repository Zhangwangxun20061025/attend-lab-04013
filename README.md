# Attendance Lab — Render 部署教程

## 你需要准备的东西
1. 一个 GitHub 账号（没有就去 github.com 注册）
2. 电脑上装了 Git（你已经装了 GitHub Desktop，够了）

## 第一步：把代码上传到 GitHub

1. 打开 GitHub，右上角点 "+" → "New repository"
2. Repository name 填：`attend-lab`
3. 选 Public
4. 不要勾选 "Add a README file"
5. 点 "Create repository"

创建好后，打开 Git Bash 或者 GitHub Desktop，在本文件夹下执行：

```bash
cd C:\Users\Lenovo\Doubao\chats\2026-10-22\new-chat\attend-lab
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/你的用户名/attend-lab.git
git push -u origin main
```

## 第二步：在 Render 上部署

1. 打开 https://render.com ，用 GitHub 账号登录
2. 点右上角 "New +" → "Web Service"
3. 找到你刚建的 `attend-lab` 仓库，点 "Connect"
4. 填写配置：
   - **Name**: `attend04013` （这会决定你的网址）
   - **Region**: 选 Singapore（离中国最近）
   - **Branch**: `main`
   - **Runtime**: Java
   - **Build Command**: `mvn clean package`
   - **Start Command**: `java -jar target/attend-lab-1.0.jar`
   - **Instance Type**: Free
5. 点 "Create Web Service"

## 第三步：等部署完成

- 第一次部署要 3-5 分钟（Maven 下载依赖比较慢）
- 看到 "Your service is live" 就成功了
- 访问 https://attend04013.onrender.com/ 测试

## 注意
- 免费版 15 分钟没人访问会自动休眠，第一次打开要等 30 秒
- 签到数据存在内存里，服务重启后会清空
