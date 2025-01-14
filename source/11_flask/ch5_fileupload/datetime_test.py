# 날짜시간형 데이터를 원하는 format으로 출력(python, Jinja2)
import datetime
dt = datetime.datetime.now()
print(dt)
print(dt.year, dt.month, dt.day)
print(dt.hour, dt.minute, dt.second)

print(dt.strftime("%Y-%m-%d"))
print(dt.strftime("%H:%M:%S"))