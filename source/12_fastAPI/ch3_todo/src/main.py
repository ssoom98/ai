# src -> 소스 루트
# pip install fastapi
# pip install uvicorn
# pip install jinja2
# pip install python_multipart (post사용)

from fastapi import FastAPI
from fastapi import Request # template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from models import ToDoRequest
from fastapi import Form # create(POST방식) 때 사용
from fastapi import HTTPException
import os

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__))#  현폴더의 절대 경로
app.mount('/static',
          StaticFiles(directory=os.path.join(BASE_DIR,'../static')),
          name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR,'../templates'))

@app.get('/')
async def health_check_handler():
    return {'status':'ok'}

todo_data={
    1:{
        'id':1,
        'contents':'딥러닝',
        'is_done':True
    },
    2:{
        'id':2,
        'contents':'fastAPI공부',
        'is_done':False
    },
    3:{
        'id':3,
        'contents':'머신러닝 공부',
        'is_done':False
    },
    4:{
        'id':4,
        'contents':'장고 공부',
        'is_done':False
    }

}


@app.get('/todos')
async def get_todos_handler(order:str|None=None):
    todos = list(todo_data.values())
    if order and order.upper()=='DESC':
        todos = todos[::-1]
    return todos
