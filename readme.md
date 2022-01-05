## 启动

#在本机屏蔽外部ssh协议 使用本项目可以

#经典格式生成密钥 避免invalid key
ssh-keygen -m PEM

#配置本机免密
cat ~/.ssh/id_rsa.pub >> ~/.ssh/authorized_keys

#todo
配置文件 host信息
