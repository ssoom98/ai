# 파이썬 웹프로그램
      # django(프레임워크), flask, fastAPI(마이크로 프레임워크)
# 1. fastAPI : 비동기 restAPI 서버(웹) 프로그램을 만드는데 특화
      # HTTP방식 : GET(read), POST(create), PUT(update), DELETE(delete)
      # /empsch/scott /empsch?ename=scott
# 2. 자동 데이터 검증 및 문서화
# 3. 빠른 개발속도, 높은 생산성 및 성능
# pip install fastapi # 서버 프로그램을 만들기 위한 마이크로 프레임워크
# pip install uvicorn # 서버

from fastapi import FastAPI

app = FastAPI()

@app.get('/')
async def index(): # async:비동기 처리(안쓰면 동기함수)
  return {'message' : 'Hello, FastApi. 안녕, 한글'}
  # 실행방법 : 터미널에서 uvicorn 파일명:fastapi객체명 --port=8000 --reload

@app.get('/test1')
async def test1():
  return ['둘리', '또치', '도우너']

@app.get('/test2')
async def test2():
  return '<h1>안녕, FastAPI</h1>'

@app.get('/test3')
async def test3():
  return 1000