#!/bin/bash

echo "==========================关闭原服务=========================="
PID=$(ps -ef|grep buy-alibaba-0.0.1-SNAPSHOT.jar|grep -v grep|awk '{print $2}')
if [ -z $PID ]; then
        echo "不存在该服务进程"
else
        echo "process id: $PID"
        kill -9 ${PID}
        echo "已删除原服务进程"
fi

echo "==========================进入git项目目录=========================="
cd  /data/codes/buy-alibaba/
echo "==========================git切换 dev分支=========================="
git checkout dev
echo "==========================git fetch=========================="
git fetch
echo "==========================git pull=========================="
git pull
echo "==========================删除打包目录=========================="
rm -rf  /data/codes/buy-alibaba/sale-starter/target/
echo "==========================编译并跳过单元测试=========================="
mvn  clean package -Dmaven.test.skip=true -Ptest
echo "==========================开始启动服务=========================="
#java -jar /data/codes/buy-alibaba/sale-starter/target/buy-alibaba-0.0.1-SNAPSHOT.jar
nohup java -server -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/data/jdk_log/dump/heap/ -Xmx512m -Xms512m -XX:+DisableExplicitGC -verbose:gc -Xloggc:/data/jdk_log/dump/gc.%t.log -XX:+PrintHeapAtGC -XX:+PrintTenuringDistribution -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCTaskTimeStamps -XX:+PrintGCDetails -XX:+PrintGCDateStamps -jar /data/codes/buy-alibaba/sale-starter/target/buy-alibaba-0.0.1-SNAPSHOT.jar > /data/logs/buy-alibaba/applog.log 2>&1 & tail -f /data/logs/buy-alibaba/applog.log
echo "==========================SUCCESS!!!=========================="
