# pip install fastapi
# pip install uvicorn
# pip install jinja2
# pip install python-multipart
from fastapi import FastAPI, Request # 템플릿 사용
from fastapi import File, UploadFile # 파일첨부
from fastapi.staticfiles import StaticFiles # static mout
from fastapi.templating import Jinja2Templates # 템플릿 지정
from starlette.responses import RedirectResponse # redirect
from starlette.exceptions import HTTPException # 예외발생
from fastapi.responses import FileResponse # 파일 다운로드

import os
import datetime

app = FastAPI()
app.mount('/static',StaticFiles(directory="static"), name='static')
templates = Jinja2Templates(directory="templates")

UPLOAD_FOLDER = './upload/'
os.makedirs(UPLOAD_FOLDER,
            exist_ok=True) # 디렉토리가 없을 때만 생성

def stamp2real(stamp):
  return datetime.datetime.fromtimestamp(stamp)

def info(filename):
  create = stamp2real(os.path.getctime(filename))
  modify = stamp2real(os.path.getmtime(filename))
  access = stamp2real(os.path.getatime(filename))
  tempsize = os.path.getsize(filename)
  size = ''
  if tempsize < 1024*1024:
    size = '{:.2f}KB'.format(tempsize / 1024)
  else:
    size = '{:.2f}MB'.format(tempsize / (1024*1024))
  return create, modify, access, size

@app.get('/')
@app.post('/')
async def index(request : Request):
  filelist = os.listdir(UPLOAD_FOLDER)
  infos = []
  for filename in filelist:
    create, modify, access, size = info(UPLOAD_FOLDER + filename)
    infos.append({
      'name':filename,
      'create':create,
      'modify':modify,
      'size':size
    })
  return templates.TemplateResponse('home.html',
                                    {'request':request,
                                     'infos':infos})

@app.post('/upload')
async def upload(requset:Request, file:UploadFile=File()):
  if file.filename: # 파일첨부 했음
    #file_path = UPLOAD_FOLDER + file.filename
    file_path = os.path.join(UPLOAD_FOLDER, file.filename)
    with open(file_path, 'wb') as buffer:
      buffer.write(await file.read()) # await : 비동기로 read() 함수 수행
    create, modify, access, size = info(file_path)
    fileinfo = {'ctime':create,
                'size':size}
    return templates.TemplateResponse('check.html',
                                      {'request':requset,
                                       'fileinfo':fileinfo})

  else: # 파일첨부 안 함
    return RedirectResponse(url='/',
                            status_code=307)

@app.get('/del/{filename}')
async def delete(filename:str):
  os.remove(UPLOAD_FOLDER+filename)
  return RedirectResponse('/')