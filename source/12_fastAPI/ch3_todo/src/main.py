# pip freeze > 파일명(requirments.txt)
# src -> 소스 루트
# pip install fastapi
# pip install uvicorn --no-cache-dir
# pip install jinja2
# pip install python_multipart (post사용)

from fastapi import FastAPI
from fastapi import Request # template으로 갈 핸들러 함수 매개변수
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from starlette.responses import RedirectResponse

from models import ToDoRequest
from fastapi import Form # create(POST방식) 때 사용
from fastapi import HTTPException # 예외 처리시 사용
import os

app = FastAPI()
BASE_DIR = os.path.dirname(os.path.abspath(__file__))#  현폴더의 절대 경로
app.mount('/static',
          StaticFiles(directory=os.path.join(BASE_DIR,'../static')),
          name='static')
templates = Jinja2Templates(directory=os.path.join(BASE_DIR,'../templates'))


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

@app.get('/')
# async def health_check_handler():
#     return {'status':'ok'}
@app.get('/todos')
@app.post('/todos')
async def get_todos_handler(request:Request,order:str|None=None):

    todos = list(todo_data.values())
    if order and order.upper()=='DESC':
        todos = todos[::-1]
    next_id = max(todo_data.keys())+1
    return templates.TemplateResponse('todos.html', # todo 목록 , todo 입력 form
                                      {'request':request,
                                       'todos':todos,
                                       'next_id':next_id,
                                       'order':order.upper() if order else ''})
# 상세보기: 없는 id 조회시 404 예외 발생
@app.get('/todos/{todo_id}')
async def get_todo_detail_handler(request:Request, todo_id:int):
    todo= todo_data.get(todo_id,{})#todo_data[todo_id]#
    if todo:
        return templates.TemplateResponse('todo.html',{'request':request,'todo':todo})
    raise HTTPException(status_code=404,detail='없는 id입니다')

@app.exception_handler(404)
def error_handler(request:Request, exe:HTTPException):
    return templates.TemplateResponse('page_not_found.html',
                                      {'request':request},
                                      status_code=404)

@app.post('/create')
async def create_todo_handler(todo:ToDoRequest=Form()):
    #print('form태그로부터 입력된 todo :',todo)
    todo_data[todo.id] =todo.dict()
    #{'id':todo.id,'contents':todo.contents,'is_done':todo.is_done}
    return RedirectResponse('/todos')

@app.delete('/delete/{todo_id}',status_code=200)
async def delete_todo_handler(todo_id:int):
    #del todo_data[todo_id]
    # 키가 없는 todo_id를 입력할 경우 None
    todo = todo_data.pop(todo_id,None)
    if todo:
        return f'{todo_id}번 삭제 성공'
    raise HTTPException(status_code=404,
                        detail='예외 페이지로 감')


@app.get('/update/{id}',status_code=200)
async def get_updatetodo_handler(request:Request, id:int):
    todo = todo_data.get(id)
    if todo:
        return templates.TemplateResponse('update.html',
                                      {'request':request,
                                       'todo':todo})
    raise HTTPException(status_code=404,
                        detail='예외 페이지로 가서 이 detail 메세지는 출력 안함')

@app.patch('/update/{id}/{contents}/{is_done}',status_code=200)
async def update_todo_handler(id:int,contents:str,is_done:bool):
    todo= todo_data.get(id) # 수행될 딕셔너리
    if todo:
        todo['contents'] =contents
        todo['is_done'] = is_done
        return f'{id}번 {contents} 수정완료'
    raise HTTPException(status_code=404,
                        detail='예외 페이지로 가서 이 detail 메세지는 출력 안함')
