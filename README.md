# spring-redis-example
To connect to Azure Redis through Redis Cli command line, do the follwing:
Download Redis CLI from,
https://redis.io/topics/quickstart 

Download stunnel from below URL & install.
https://www.stunnel.org/downloads.html 

Make configuration changes with entry (this is for test)
[redis-cli]
client=yes  
accept=127.0.0.1:6830  
connect=xxxxx.redis.cache.windows.net:6380

Open command prompt  Go to Redis Directory and  run below command. We will have to change password based on environment we want to connect
D:\redis-latest>redis-cli.exe -h 127.0.0.1 -p 6830 -a Azure Redis password

You can execute FLUSHALL command to clear all the keys. In case if we are loading specific entity, we can execute redis-cli --raw keys "$PATTERN" | xargs redis-cli del
